package com.library.librarymanagesystem.controller;

import com.library.librarymanagesystem.data.models.Author;
import com.library.librarymanagesystem.dtos.request.AuthorCreateRequest;
import com.library.librarymanagesystem.dtos.response.AuthorCreateResponse;
import com.library.librarymanagesystem.services.serviceInterface.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @PostMapping("/create")
    public ResponseEntity<AuthorCreateResponse> createAuthor(@RequestBody AuthorCreateRequest authorCreateRequest){
        return new ResponseEntity<>(authorService.createAuthor(authorCreateRequest), HttpStatus.OK);
    }
}
