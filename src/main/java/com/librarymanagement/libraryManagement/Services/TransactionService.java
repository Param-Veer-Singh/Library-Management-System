package com.librarymanagement.libraryManagement.Services;

import com.librarymanagement.libraryManagement.Enums.Card_Status;
import com.librarymanagement.libraryManagement.Enums.TransactionStatus;
import com.librarymanagement.libraryManagement.Enums.TransactionType;
import com.librarymanagement.libraryManagement.Models.Book;
import com.librarymanagement.libraryManagement.Models.LibraryCard;
import com.librarymanagement.libraryManagement.Models.Transaction;
import com.librarymanagement.libraryManagement.Repository.BookRepository;
import com.librarymanagement.libraryManagement.Repository.CardRepository;
import com.librarymanagement.libraryManagement.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private BookRepository bookRepository;

    @Value("${book.maxLimit}")
    private Integer maxLimit;

    public ResponseEntity issueBook(Integer cardId, Integer bookId) throws Exception {

        Transaction transaction = new Transaction(TransactionStatus.PENDING, TransactionType.ISSUE,0);

        Optional<LibraryCard> libraryCard = cardRepository.findById(cardId);
        Optional<Book> book = bookRepository.findById(bookId);

        if(!libraryCard.isPresent()) throw new Exception("Card Id invalid");
        else if(!book.isPresent()) throw new Exception("Book Id is invalid");
        else{
            if(!libraryCard.get().getCardStatus().equals(Card_Status.ACTIVE)){

                transaction.setTransactionStatus(TransactionStatus.FAILED);
                transaction = transactionRepository.save(transaction);

                throw new Exception("Card not active");
            }else if(!book.get().getIsAvailable()){

                transaction.setTransactionStatus(TransactionStatus.FAILED);
                transaction = transactionRepository.save(transaction);

                throw new Exception("Book is not available");
            }else if(libraryCard.get().getNoOfBooksIssued() >= maxLimit){
                transaction.setTransactionStatus(TransactionStatus.FAILED);
                transaction = transactionRepository.save(transaction);

                throw new Exception("Max limit reached");
            }else{

                transaction.setTransactionStatus(TransactionStatus.SUCCESS);

                book.get().setIsAvailable(false);
                libraryCard.get().setNoOfBooksIssued(libraryCard.get().getNoOfBooksIssued() + 1);

                transaction.setBook(book.get());
                transaction.setLibraryCard(libraryCard.get());

                Transaction newTransaction = transactionRepository.save(transaction);

                book.get().getTransactionList().add(newTransaction);
                libraryCard.get().getTransactionList().add(newTransaction);

                bookRepository.save(book.get());
                cardRepository.save(libraryCard.get());

                return  new ResponseEntity("Transaction completed successfully", HttpStatus.OK);
            }
        }
    }

    public ResponseEntity returnBook(Integer cardId, Integer bookId){

        Book book = bookRepository.findById(bookId).get();
        LibraryCard libraryCard = cardRepository.findById(cardId).get();

        List<Transaction> transactionList = transactionRepository.findTransactionsByBookAndLibraryCardAndTransactionStatusAndTransactionType(book,libraryCard, TransactionStatus.SUCCESS,TransactionType.ISSUE);

        Transaction latestTransaction = transactionList.get(transactionList.size() - 1);

        Date issuedDate = latestTransaction.getCreatedAt();

        long milliSecondTime = Math.abs(System.currentTimeMillis() - issuedDate.getTime());
        long no_of_days_issued = TimeUnit.DAYS.convert(milliSecondTime,TimeUnit.MILLISECONDS);

        int fineAmount = 0;

        if(no_of_days_issued > 15){
            fineAmount = (int)(no_of_days_issued * 10);
        }

        libraryCard.setNoOfBooksIssued(libraryCard.getNoOfBooksIssued() - 1);
        book.setIsAvailable(true);

        Transaction transaction = new Transaction(TransactionStatus.SUCCESS,TransactionType.RETURN,fineAmount);

        transaction.setBook(book);
        transaction.setLibraryCard(libraryCard);

       Transaction newTransaction = transactionRepository.save(transaction);

       book.getTransactionList().add(newTransaction);
       libraryCard.getTransactionList().add(newTransaction);

       bookRepository.save(book);
       cardRepository.save(libraryCard);

       return new ResponseEntity("Returned book successfully", HttpStatus.OK);
    }
}
