package com.library.librarymanagesystem.dtos.request;

import lombok.Data;

@Data
public class UpdateBookRequest {
    private Long availableQuantity;
    private Long bookId;
}
