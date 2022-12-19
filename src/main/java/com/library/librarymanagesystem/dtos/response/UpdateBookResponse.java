package com.library.librarymanagesystem.dtos.response;

import lombok.Data;

@Data
public class UpdateBookResponse {
    private Long updatedQuantity;
    private String isbn;
    private String name;
}
