package com.library.librarymanagesystem.services.serviceImplementation;

import com.library.librarymanagesystem.dtos.request.AuthorCreateRequest;
import com.library.librarymanagesystem.services.serviceInterface.AuthorService;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class AuthorServiceImplTest {
    private AuthorCreateRequest authorCreateRequest;
    private AuthorService authorService;

    @BeforeEach
    void setUp() {
        authorCreateRequest = new AuthorCreateRequest();
        authorService = new AuthorServiceImpl();
    }
    @Test
    void authorCanBeCreated_test(){
        authorCreateRequest.setEmail("adulojujames@gmail.com");
        authorCreateRequest.setPassword("1234");
        authorCreateRequest.setFirstName("James");
        authorCreateRequest.setLastName("Adeniyi");
        authorService.createAuthor(authorCreateRequest);
        assertEquals("adulojujames@gmail.com", authorCreateRequest.getEmail());


    }
}