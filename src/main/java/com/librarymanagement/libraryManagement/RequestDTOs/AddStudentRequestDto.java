package com.librarymanagement.libraryManagement.RequestDTOs;

import com.librarymanagement.libraryManagement.Enums.Department;
import com.librarymanagement.libraryManagement.Enums.Gender;
import lombok.Data;

@Data
public class AddStudentRequestDto {

    private String name;
    private Integer age;
    private String email;
    private Gender gender;
    private Department department;
}
