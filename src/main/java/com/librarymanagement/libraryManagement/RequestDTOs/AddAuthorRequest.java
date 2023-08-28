package com.librarymanagement.libraryManagement.RequestDTOs;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddAuthorRequest {

    private String name;
    private String email;
    private String penName;
}
