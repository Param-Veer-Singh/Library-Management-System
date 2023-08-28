package com.librarymanagement.libraryManagement.Controllers;

import com.librarymanagement.libraryManagement.Models.Author;
import com.librarymanagement.libraryManagement.RequestDTOs.AddAuthorRequest;
import com.librarymanagement.libraryManagement.Services.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
@Slf4j
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public ResponseEntity addAuthor(@RequestBody AddAuthorRequest addAuthorRequest){
        return authorService.addAuthor(addAuthorRequest);
    }

    @GetMapping("/getById")
    public ResponseEntity getAuthorById(@RequestParam("authorId") Integer authorId) throws Exception {
        return authorService.getAuthorById(authorId);
    }

    @GetMapping("/getByName")
    public ResponseEntity getAuthorByName(@RequestParam("authorName") String name){
        return authorService.getAuthorByName(name);
    }
}
