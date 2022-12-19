package com.library.librarymanagesystem.dtos.response;

import lombok.Data;

@Data
public class DeletedBookResponse {
    private String bookAuthor;
    private String status;
    private String message;
}
