package com.library.librarymanagesystem.services.serviceInterface;

import com.library.librarymanagesystem.dtos.request.AuthorCreateRequest;
import com.library.librarymanagesystem.dtos.response.AuthorCreateResponse;

public interface AuthorService {
    AuthorCreateResponse createAuthor(AuthorCreateRequest authorCreateRequest);
}
