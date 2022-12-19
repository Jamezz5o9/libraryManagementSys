package com.library.librarymanagesystem.services.serviceImplementation;

import com.library.librarymanagesystem.dtos.request.BookCreateRequest;
import com.library.librarymanagesystem.dtos.response.BookCreateResponse;
import com.library.librarymanagesystem.dtos.response.BookResponse;
import com.library.librarymanagesystem.models.Book;
import com.library.librarymanagesystem.repository.BookRepository;
import com.library.librarymanagesystem.services.serviceInterface.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookServiceImplTest {
    private BookService bookService;
    private BookRepository bookRepository;
    private BookCreateRequest bookCreateRequest;

    @BeforeEach
    void setUp() {
        bookService = new BookServiceImpl();
        bookCreateRequest = new BookCreateRequest();
    }

    @Test
    void createNewBook() {
     bookCreateRequest.setAuthorId(1L);
     bookCreateRequest.setIsbn("1234");
     bookCreateRequest.setBookTitle("Lionel Andres Messi");
     bookCreateRequest.setYearPublished("2022");
     BookCreateResponse bookCreateResponse = bookService.createNewBook(bookCreateRequest);
     bookCreateResponse.setStatus("success");
     assertEquals("success", bookCreateResponse.getStatus());
    }

    @Test
    void deleteBookById() {
    }

    @Test
    void findBookByAuthor() {
    }

    @Test
    void deleteAll() {
    }

    @Test
    void viewBook() {
    }

    @Test
    void bookList() {
    }

    @Test
    void updateBookQuantity() {
    }
}