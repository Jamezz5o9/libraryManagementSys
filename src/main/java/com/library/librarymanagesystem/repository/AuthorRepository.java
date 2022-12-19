package com.library.librarymanagesystem.repository;

import com.library.librarymanagesystem.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;



public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findAuthorByEmail(String email);
}
