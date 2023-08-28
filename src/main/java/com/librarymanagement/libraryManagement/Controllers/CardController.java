package com.librarymanagement.libraryManagement.Controllers;

import com.librarymanagement.libraryManagement.Models.LibraryCard;
import com.librarymanagement.libraryManagement.Services.LibraryCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private LibraryCardService libraryCardService;

    @PostMapping("/createCard")
    private ResponseEntity createCard(@RequestParam("studentId") Integer id) throws Exception {

        return libraryCardService.createCard(id);
    }
}
