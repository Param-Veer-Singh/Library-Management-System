package com.librarymanagement.libraryManagement.Services;

import com.librarymanagement.libraryManagement.Models.Author;
import com.librarymanagement.libraryManagement.Models.Book;
import com.librarymanagement.libraryManagement.Repository.AuthorRepository;
import com.librarymanagement.libraryManagement.RequestDTOs.AddAuthorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public ResponseEntity addAuthor(AddAuthorRequest addAuthorRequest){
        String name = addAuthorRequest.getName();
        String email = addAuthorRequest.getEmail();
        String penName = addAuthorRequest.getPenName();

        Author author = new Author(name,email,penName);

        authorRepository.save(author);

        return new ResponseEntity( "Author has been added successfully", HttpStatus.OK);
    }

    public ResponseEntity getAuthorById(Integer authorId) {
        Optional<Author> author = authorRepository.findById(authorId);
        if(author.isPresent()){
            return new ResponseEntity(author.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity("Invalid Author Id",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity getAuthorByName(String name){
        List<Author> listOfAuthor = authorRepository.findAll();

        for(Author author : listOfAuthor) {
            if (author.toString().equals(name)) {
                return new ResponseEntity(author, HttpStatus.OK);
            }
        }
        return new ResponseEntity("Author not found",HttpStatus.OK);
    }

}
