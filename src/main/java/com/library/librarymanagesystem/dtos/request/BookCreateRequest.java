package com.library.librarymanagesystem.dtos.request;

import lombok.Data;

@Data
public class BookCreateRequest {
    private String isbn;
    private String yearPublished;
    private String bookTitle;
    private Long authorId;
}
