package com.librarymanagement.libraryManagement.Repository;

import com.librarymanagement.libraryManagement.Enums.TransactionStatus;
import com.librarymanagement.libraryManagement.Enums.TransactionType;
import com.librarymanagement.libraryManagement.Models.Book;
import com.librarymanagement.libraryManagement.Models.LibraryCard;
import com.librarymanagement.libraryManagement.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
        @Query(value = "select * from transaction where book =: book AND libraryCard =: card AND transactionStatus =: transactionStatus AND transactionType =: transactionType ;", nativeQuery = true)
        List<Transaction> findTransactionsByBookAndLibraryCardAndTransactionStatusAndTransactionType(Book book, LibraryCard card, TransactionStatus transactionStatus, TransactionType transactionType);
}
