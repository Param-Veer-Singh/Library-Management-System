package com.librarymanagement.libraryManagement.Controllers;

import com.librarymanagement.libraryManagement.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/issueBook")
    public ResponseEntity issueBook(@RequestParam("cardId") Integer cardId, @RequestParam("bookId")Integer bookId){
        try{
            return transactionService.issueBook(cardId,bookId);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/returnBook")
    public ResponseEntity returnBook(@RequestParam("cardId") Integer cardId, @RequestParam("bookId")Integer bookId){
        try{
            return transactionService.returnBook(cardId,bookId);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
