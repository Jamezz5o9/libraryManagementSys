package com.library.librarymanagesystem.data.repository;

import com.library.librarymanagesystem.data.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findAuthorByEmail(String email);
}
