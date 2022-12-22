package com.library.librarymanagesystem.dtos.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class BookResponse {
    private String name;
    private String isbn;
    private String author;
}
