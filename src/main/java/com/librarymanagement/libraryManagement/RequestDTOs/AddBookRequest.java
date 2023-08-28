package com.librarymanagement.libraryManagement.RequestDTOs;

import com.librarymanagement.libraryManagement.Enums.Genres;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AddBookRequest {

    private String title;
    private Boolean isAvailable;
    private Genres genre;
    private Date publicationDate;
    private Integer price;
    private Integer authorId;
}
