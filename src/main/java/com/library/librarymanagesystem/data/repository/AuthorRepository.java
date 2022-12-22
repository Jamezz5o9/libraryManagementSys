package com.library.librarymanagesystem.data.repository;

import com.library.librarymanagesystem.data.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findAuthorByEmail(String email);
    Optional<Author> findAuthorById(Long id);

    void deleteAuthorByEmail(String email);
}
