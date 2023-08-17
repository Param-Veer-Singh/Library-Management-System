package com.librarymanagement.libraryManagement.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;

    private String name;

    private String email;

    private String penName;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Books> booksList = new ArrayList<>();

}
