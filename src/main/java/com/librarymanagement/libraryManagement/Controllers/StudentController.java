package com.librarymanagement.libraryManagement.Controllers;

import com.librarymanagement.libraryManagement.Repository.StudentRepository;
import com.librarymanagement.libraryManagement.RequestDTOs.AddStudentRequestDto;
import com.librarymanagement.libraryManagement.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody AddStudentRequestDto addStudentRequestDto){
        return studentService.addStudent(addStudentRequestDto);
    }
}
