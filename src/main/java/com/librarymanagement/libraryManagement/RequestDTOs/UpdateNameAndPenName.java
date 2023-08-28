package com.librarymanagement.libraryManagement.RequestDTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateNameAndPenName {

    private Integer authorId;
    private String newName;
    private String newPenName;
}
