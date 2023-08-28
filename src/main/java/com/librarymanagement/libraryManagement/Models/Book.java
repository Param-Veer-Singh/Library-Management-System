package com.librarymanagement.libraryManagement.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.librarymanagement.libraryManagement.Enums.Genres;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    @Column(unique = true)
    private String title;

    @Enumerated(value = EnumType.STRING)
    private Genres genre;

    private Date publicationDate;

    private Boolean isAvailable;

    private Integer price;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Author author;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Transaction> transactionList = new ArrayList<>();

    public Book(String title, Genres genre, Date publicationDate, Boolean isAvailable, Integer price) {
        this.title = title;
        this.genre = genre;
        this.publicationDate = publicationDate;
        this.isAvailable = isAvailable;
        this.price = price;
    }
}
