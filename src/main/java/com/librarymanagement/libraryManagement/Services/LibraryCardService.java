package com.librarymanagement.libraryManagement.Services;

import com.librarymanagement.libraryManagement.Enums.Card_Status;
import com.librarymanagement.libraryManagement.Models.LibraryCard;
import com.librarymanagement.libraryManagement.Models.Student;
import com.librarymanagement.libraryManagement.Repository.CardRepository;
import com.librarymanagement.libraryManagement.Repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class LibraryCardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private StudentRepository studentRepository;

    public ResponseEntity createCard(Integer id) throws Exception {
        log.error("here 1");
        Optional<Student> student = studentRepository.findById(id);
        if(!student.isPresent()){
            throw new Exception("Invalid student id");
        }else{
            LibraryCard libraryCard = new LibraryCard();

            log.error("I am here 2");
            libraryCard.setCardStatus(Card_Status.ACTIVE);
            libraryCard.setNoOfBooksIssued(0);
            libraryCard.setStudent(student.get());

            student.get().setLibraryCard(libraryCard);

            studentRepository.save(student.get());

            return new ResponseEntity("New Card created", HttpStatus.OK);
        }
    }
}
