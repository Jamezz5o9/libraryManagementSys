package com.library.librarymanagesystem.services.serviceImplementation;

import com.library.librarymanagesystem.dtos.request.AuthorCreateRequest;
import com.library.librarymanagesystem.dtos.response.AuthorCreateResponse;
import com.library.librarymanagesystem.data.models.Author;
import com.library.librarymanagesystem.data.repository.AuthorRepository;
import com.library.librarymanagesystem.exception.AuthorException;
import com.library.librarymanagesystem.services.serviceInterface.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private AuthorRepository authorRepository;
    @Override
    public AuthorCreateResponse createAuthor(AuthorCreateRequest authorCreateRequest) {
        //Author exist Exception or update author?
       if(authorRepository.findAuthorByEmail(authorCreateRequest.getEmail()) != null) throw new AuthorException("Author already Exist");
       else{
           Author author = Author.builder()
                   .email(authorCreateRequest.getEmail())
                   .firstName(authorCreateRequest.getFirstName())
                   .lastName(authorCreateRequest.getLastName())
                   .password(authorCreateRequest.getPassword())
                   .createdDate(Instant.now())
                   .modifiedDate(Instant.now())
                   .build();
           Author savedAuthor = authorRepository.save(author);
           return mapper.map(savedAuthor, AuthorCreateResponse.class);
       }
    }
}
