package com.library.librarymanagesystem.data.repository;

import com.library.librarymanagesystem.data.models.Admin;
import com.library.librarymanagesystem.data.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Override
    Optional<Admin> findById(Long id);
    Optional<Admin> findAdminByEmail(String email);
    String deleteAdminByEmail(String email);
}
