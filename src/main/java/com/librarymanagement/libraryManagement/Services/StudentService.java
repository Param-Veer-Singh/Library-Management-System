package com.librarymanagement.libraryManagement.Services;

import com.librarymanagement.libraryManagement.Models.Student;
import com.librarymanagement.libraryManagement.Repository.StudentRepository;
import com.librarymanagement.libraryManagement.RequestDTOs.AddStudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public ResponseEntity addStudent(AddStudentRequestDto addStudentRequestDto){

        Student student = new Student();
        student.setName(addStudentRequestDto.getName());
        student.setAge(addStudentRequestDto.getAge());
        student.setGender(addStudentRequestDto.getGender());
        student.setEmail(addStudentRequestDto.getEmail());
        student.setDepartment(addStudentRequestDto.getDepartment());

        studentRepository.save(student);

        return new ResponseEntity("Student has been saved successfully", HttpStatus.OK);
    }
}
