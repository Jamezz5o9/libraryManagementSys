package com.library.librarymanagesystem.dtos.response;

import lombok.Data;

@Data
public class BookCreateResponse {
    private String status;
    private String message;
    private String isbn;
}
