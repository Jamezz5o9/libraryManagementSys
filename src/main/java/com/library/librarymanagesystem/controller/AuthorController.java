package com.library.librarymanagesystem.controller;

import com.library.librarymanagesystem.data.models.Author;
import com.library.librarymanagesystem.dtos.request.AuthorCreateRequest;
import com.library.librarymanagesystem.dtos.response.AuthorCreateResponse;
import com.library.librarymanagesystem.services.serviceInterface.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @PostMapping("/createAuthor")
    public ResponseEntity<AuthorCreateResponse> createAuthor(@RequestBody AuthorCreateRequest authorCreateRequest){
        return new ResponseEntity<>(authorService.createAuthor(authorCreateRequest), HttpStatus.OK);
    }
    @GetMapping("/deleteByEmail/{email}")
    public ResponseEntity<String> deleteByEmail(@PathVariable String email){
        return new ResponseEntity<>(authorService.deleteAuthorByEmail(email), HttpStatus.OK);
    }

    @GetMapping("/deleteAll")
    public ResponseEntity<String> deleteAllAuthor(){
        return new ResponseEntity<>(authorService.deleteAllAuthor(), HttpStatus.OK);
    }
    @GetMapping("/getAuthorByEmail/{email}")
    public ResponseEntity<Author> getAuthorByEmail(@PathVariable String email){
        return new ResponseEntity<>(authorService.getAuthorByEmail(email), HttpStatus.OK);
    }
    @GetMapping("/getAuthorById/{authorId}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long authorId){
        return new ResponseEntity<>(authorService.getAuthorById(authorId), HttpStatus.OK);
    }

    @GetMapping("/deleteAuthorById/{authorId}")
    public ResponseEntity<String> deleteAuthorById(@PathVariable Long authorId){
        return new ResponseEntity<>(authorService.deleteAuthorById(authorId), HttpStatus.OK);
    }

}
