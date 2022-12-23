package com.library.librarymanagesystem.services.serviceImplementation;

import com.library.librarymanagesystem.LibrarymanagesystemApplication;
import com.library.librarymanagesystem.dtos.request.BookCreateRequest;
import com.library.librarymanagesystem.dtos.response.BookCreateResponse;
import com.library.librarymanagesystem.services.serviceInterface.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest(classes = {LibrarymanagesystemApplication.class})
class BookServiceImplTest {
    private BookService bookService;
    private BookCreateRequest bookCreateRequest;

    @BeforeEach
    void setUp() {
        bookService = new BookServiceImpl();
        bookCreateRequest = new BookCreateRequest();
    }

    @Test
    void createNewBook() {
     bookCreateRequest.setAuthorId(1L);
     bookCreateRequest.setIsbn(200L);
     bookCreateRequest.setBookTitle("Lionel Andres Messi");
     bookCreateRequest.setYearPublished("2022");
     BookCreateResponse bookCreateResponse = bookService.createBook(bookCreateRequest);
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