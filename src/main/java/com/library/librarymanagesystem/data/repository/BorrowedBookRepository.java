package com.library.librarymanagesystem.data.repository;

import com.library.librarymanagesystem.data.models.BorrowedBook;
import com.library.librarymanagesystem.data.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Long> {
}
