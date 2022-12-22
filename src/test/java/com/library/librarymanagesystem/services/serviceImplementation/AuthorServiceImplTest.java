package com.library.librarymanagesystem.services.serviceImplementation;

import com.library.librarymanagesystem.LibrarymanagesystemApplication;
import com.library.librarymanagesystem.data.models.Author;
import com.library.librarymanagesystem.dtos.request.AuthorCreateRequest;
import com.library.librarymanagesystem.dtos.response.AuthorCreateResponse;
import com.library.librarymanagesystem.services.serviceInterface.AuthorService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {LibrarymanagesystemApplication.class})
class AuthorServiceImplTest {
    @Autowired
    private AuthorService authorService;
    private AuthorCreateRequest authorCreateRequest;
    private AuthorCreateResponse authorCreateResponse;

    @BeforeEach
    void setUp() {
        authorCreateRequest = new AuthorCreateRequest();
        authorCreateRequest.setEmail("adulojujames@gmail.com");
        authorCreateRequest.setFirstName("James");
        authorCreateRequest.setLastName("Adeniyi");
        authorCreateRequest.setPhoneNumber("9686767");
        authorCreateResponse = authorService.createAuthor(authorCreateRequest);
    }
    @AfterEach
    void tearDown(){
        authorService.deleteAllAuthor();
    }
    @Test
    void authorCanBeCreated_test(){
        System.out.println(authorCreateResponse.getId());
        assertNotNull(authorCreateResponse.getId());
        assertEquals("adulojujames@gmail.com", authorCreateResponse.getEmail());
    }
    @Test
    void authorCanBeDeletedByEmailTest(){
        authorService.deleteAuthorByEmail("adulojujames@gmail.com");
        List<Author> authorList = authorService.getAllAuthor();
        assertEquals(0, authorList.size());
    }

}