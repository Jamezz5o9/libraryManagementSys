package com.library.librarymanagesystem.data.repository;

import com.library.librarymanagesystem.data.models.Book;
import com.library.librarymanagesystem.data.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
