package com.library.librarymanagesystem.dtos.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class BookAuthorResponse {
    private String isbn;
    private String author;
    @JsonIgnore
    private Long id;
    private String message;
}
