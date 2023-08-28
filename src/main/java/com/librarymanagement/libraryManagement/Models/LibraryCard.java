package com.librarymanagement.libraryManagement.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.librarymanagement.libraryManagement.Enums.Card_Status;
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

    @OneToMany(mappedBy = "libraryCard", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Transaction> transactionList = new ArrayList<>();

}
