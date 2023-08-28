package com.librarymanagement.libraryManagement.ResponseDTOs;

import com.librarymanagement.libraryManagement.Enums.Genres;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {

    private String title;
    private Boolean isAvailable;
    private Genres genre;
    private Date publicationDate;
    private Integer price;
    private String authorName;
}
