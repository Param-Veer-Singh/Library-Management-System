package com.librarymanagement.libraryManagement.Services;

import com.librarymanagement.libraryManagement.Enums.Genres;
import com.librarymanagement.libraryManagement.Models.Author;
import com.librarymanagement.libraryManagement.Models.Book;
import com.librarymanagement.libraryManagement.Repository.AuthorRepository;
import com.librarymanagement.libraryManagement.Repository.BookRepository;
import com.librarymanagement.libraryManagement.RequestDTOs.AddAuthorRequest;
import com.librarymanagement.libraryManagement.RequestDTOs.AddBookRequest;
import com.librarymanagement.libraryManagement.ResponseDTOs.BookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;

    public ResponseEntity addBook(AddBookRequest addBookRequest){

        Optional<Author> author = authorRepository.findById(addBookRequest.getAuthorId());
        if(author.isPresent()){
            String title = addBookRequest.getTitle();
            Genres genre = addBookRequest.getGenre();
            Date publicationDate = addBookRequest.getPublicationDate();
            Boolean isAvailable = addBookRequest.getIsAvailable();
            Integer price = addBookRequest.getPrice();

            Book book = new Book(title,genre,publicationDate,isAvailable,price);
            book.setAuthor(author.get());
//            bookRepository.save(book);

            List<Book> bookList = author.get().getBooksList();
            bookList.add(book);
            author.get().setBooksList(bookList);

            authorRepository.save(author.get());

            return new ResponseEntity("Book has been added successfully",HttpStatus.OK);
        }else return new ResponseEntity("Invalid Author Id", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity getBookById(Integer bookId){
        Optional<Book> book = bookRepository.findById(bookId);
        if(book.isPresent()){
            return new ResponseEntity(book,HttpStatus.OK);
        }else{
            return new ResponseEntity("Invalid Book Id", HttpStatus.BAD_REQUEST);
        }
    }
    public ResponseEntity getBookByTitle(String title){

        List<Book> listOfBooks = bookRepository.findAll();

        for(Book book : listOfBooks) {
            if (book.getTitle().equals(title)) {
                return new ResponseEntity(book, HttpStatus.OK);
            }
        }
        return new ResponseEntity("Book not found",HttpStatus.OK);
    }

}
