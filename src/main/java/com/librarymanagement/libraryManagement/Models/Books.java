package com.librarymanagement.libraryManagement.Models;

import com.librarymanagement.libraryManagement.Enums.Genres;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    private String title;

    @Enumerated(value = EnumType.STRING)
    private Genres genre;

    private Date publicationDate;

    private Boolean isAvailable;

    private Integer price;

    @ManyToOne
    @JoinColumn
    private Author author;

}
