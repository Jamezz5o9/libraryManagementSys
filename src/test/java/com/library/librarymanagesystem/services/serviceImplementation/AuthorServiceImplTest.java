package com.library.librarymanagesystem.services.serviceImplementation;

import com.library.librarymanagesystem.dtos.request.AuthorCreateRequest;
import com.library.librarymanagesystem.dtos.response.AuthorCreateResponse;
import com.library.librarymanagesystem.data.models.Author;
import com.library.librarymanagesystem.data.repository.AuthorRepository;
import com.library.librarymanagesystem.services.serviceInterface.AuthorService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class AuthorServiceImplTest {
    @Autowired
    private AuthorService authorService;
    @MockBean
    private AuthorRepository authorRepository;
    private AuthorCreateRequest authorCreateRequest;

    @BeforeEach
    void setUp() {
        authorCreateRequest = new AuthorCreateRequest();
        authorCreateRequest.setEmail("adulojujames@gmail.com");
        authorCreateRequest.setPassword("1234");
        authorCreateRequest.setFirstName("James");
        authorCreateRequest.setLastName("Adeniyi");

        Author author = new Author();
        author.setEmail(authorCreateRequest.getEmail());
        author.setPassword(authorCreateRequest.getPassword());
        author.setFirstName(authorCreateRequest.getFirstName());
        author.setLastName(authorCreateRequest.getLastName());
        when(authorRepository.save(author)).thenReturn(author);
    }
    @Test
    void authorCanBeCreated_test(){
        AuthorCreateResponse authorCreateResponse = authorService.createAuthor(authorCreateRequest);
        System.out.println(authorCreateResponse.getId());
        assertEquals("adulojujames@gmail.com", authorCreateResponse.getEmail());
    }
}