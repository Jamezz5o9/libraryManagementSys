package com.library.librarymanagesystem.data.repository;

import com.library.librarymanagesystem.data.models.Admin;
import com.library.librarymanagesystem.data.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
