package com.library.librarymanagesystem.services.serviceImplementation;

import com.library.librarymanagesystem.data.repository.AdminRepository;
import com.library.librarymanagesystem.dtos.request.AuthorCreateRequest;
import com.library.librarymanagesystem.dtos.request.AuthorUpdateRequest;
import com.library.librarymanagesystem.dtos.response.AuthorCreateResponse;
import com.library.librarymanagesystem.data.models.Author;
import com.library.librarymanagesystem.data.repository.AuthorRepository;
import com.library.librarymanagesystem.exception.AuthorException;
import com.library.librarymanagesystem.services.serviceInterface.AuthorService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
@Transactional
@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public AuthorCreateResponse createAuthor(AuthorCreateRequest authorCreateRequest) {
       if(authorRepository.findAuthorByEmail(authorCreateRequest.getEmail()).isPresent()) throw new AuthorException("Author already Exist");
       else {
           Author author = Author.builder()
                   .email(authorCreateRequest.getEmail())
                   .firstName(authorCreateRequest.getFirstName())
                   .lastName(authorCreateRequest.getLastName())
                   .phoneNumber(authorCreateRequest.getPhoneNumber())
                   .createdDate(Instant.now())
                   .modifiedDate(Instant.now())
                   .build();
           Author savedAuthor = authorRepository.save(author);
           return mapper.map(savedAuthor, AuthorCreateResponse.class);
       }
    }

    @Override
    public Author getAuthorById(Long id) {
       return authorRepository.findAuthorById(id).orElseThrow(() -> new AuthorException("Author with " + id + " does not exist"));
    }

    @Override
    public Author getAuthorByEmail(String email) {
        return authorRepository.findAuthorByEmail(email).orElseThrow(() -> new AuthorException("Author with " + email + " already exist"));
    }

    @Override
    public String deleteAllAuthor() {
        authorRepository.deleteAll();
        return "All authors deleted successfully";
    }

    @Override
    public String deleteAuthorById(Long id) {
        authorRepository.deleteById(id);
        return "Author with " + id + " deleted successfully";
    }

    @Override
    public String deleteAuthorByEmail(String email) {
         authorRepository.deleteAuthorByEmail(email);
         return "Author with " + email + " deleted successfully";
    }

    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }

    @Override
    public String updateAuthor(AuthorUpdateRequest authorUpdateRequest) {
        if(authorRepository.findAuthorByEmail(authorUpdateRequest.getEmail()).isEmpty()) throw new AuthorException("Author can't be empty");
        Author author = getAuthorByEmail(authorUpdateRequest.getEmail());
        if(authorUpdateRequest.getPhoneNumber() != null) author.setPhoneNumber(authorUpdateRequest.getPhoneNumber());
        if(authorUpdateRequest.getFirstName() != null) author.setFirstName(authorUpdateRequest.getFirstName());
        if(authorUpdateRequest.getLastName() != null) author.setLastName(authorUpdateRequest.getLastName());
        return "Author name " + authorUpdateRequest.getFirstName() + "\nauthor phoneNumber " + authorUpdateRequest.getPhoneNumber() + "\nauthor lastName " + authorUpdateRequest.getLastName() + "\n Updated successfully";
    }

}
