package com.library.librarymanagesystem.dtos.request;

import com.library.librarymanagesystem.data.models.Book;
import lombok.Data;

@Data
public class AddBookRequest {
    private Book book;
    private Long authorId;
}
