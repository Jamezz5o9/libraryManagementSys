package com.library.librarymanagesystem.dtos.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class BookCreateResponse {
    private String status;
    private String message;
    @JsonIgnore
    private Long id;
    private String isbn;
}
