package com.library.librarymanagesystem.dtos.response;

import lombok.Data;

@Data
public class AddBookResponse {
    private final String  message = "Book added successfully";
    private String bookName;
}
