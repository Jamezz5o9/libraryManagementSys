package com.library.librarymanagesystem.repository;

import com.library.librarymanagesystem.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
