package com.library.librarymanagesystem.data.repository;

import com.library.librarymanagesystem.data.models.BookRequest;
import com.library.librarymanagesystem.data.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRequestRepository extends JpaRepository<BookRequest, Long> {
}
