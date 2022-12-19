package com.library.librarymanagesystem.dtos.response;

import lombok.Data;

@Data
public class BookAuthorResponse {
    private String isbn;
    private String author;
    private String message;
}
