package com.librarymanagement.libraryManagement.Models;

import com.librarymanagement.libraryManagement.Enums.Department;
import com.librarymanagement.libraryManagement.Enums.Gender;
import jakarta.persistence.*;

@Entity
@Table
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // primary key & auto

    private String name;

    private Integer age;

    @Column(unique = true)
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Enumerated(value = EnumType.STRING)
    private Department department;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private LibraryCard libraryCard;
}
