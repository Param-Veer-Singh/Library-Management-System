package com.librarymanagement.libraryManagement.Models;

import com.librarymanagement.libraryManagement.Enums.Card_Status;
import jakarta.persistence.*;

@Entity
@Table
public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardNo;

    @Enumerated(value = EnumType.STRING)
    private Card_Status cardStatus;

    private Integer noOfBooksIssued;

    @OneToOne
    @JoinColumn
    private Student student; // foreign key
}
