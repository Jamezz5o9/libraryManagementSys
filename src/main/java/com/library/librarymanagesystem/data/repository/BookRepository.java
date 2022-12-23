package com.library.librarymanagesystem.data.repository;

import com.library.librarymanagesystem.data.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findBookByIsbn(Long aLong);
    Optional<Book> findBookByTitle(String title);
    void deleteBookByIsbn(Long isbn);

}
