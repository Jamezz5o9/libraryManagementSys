package com.library.librarymanagesystem.services.serviceInterface;

import com.library.librarymanagesystem.data.models.Author;
import com.library.librarymanagesystem.dtos.request.AuthorCreateRequest;
import com.library.librarymanagesystem.dtos.response.AuthorCreateResponse;

import java.util.List;

public interface AuthorService {
    AuthorCreateResponse createAuthor(AuthorCreateRequest authorCreateRequest);
    Author getAuthorById(Long id);
    Author getAuthorByEmail(String email);
    String deleteAllAuthor();
    String deleteAuthorById(Long id);
    String deleteAuthorByEmail(String email);
    List<Author> getAllAuthor();
}
