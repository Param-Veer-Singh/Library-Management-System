package com.librarymanagement.libraryManagement.Controllers;

import com.librarymanagement.libraryManagement.Enums.Genres;
import com.librarymanagement.libraryManagement.Models.Book;
import com.librarymanagement.libraryManagement.RequestDTOs.AddBookRequest;
import com.librarymanagement.libraryManagement.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody AddBookRequest addBookRequest){
        return bookService.addBook(addBookRequest);
    }

    @GetMapping("/getById")
    public ResponseEntity getBookById(@RequestParam("bookId") Integer bookId){
        return bookService.getBookById(bookId);
    }

    @GetMapping("/getByTitle")
    public ResponseEntity getBookByTitle(@RequestParam("bookTitle") String title){
        return bookService.getBookByTitle(title);
    }

}
