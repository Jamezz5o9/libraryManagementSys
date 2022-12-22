package com.library.librarymanagesystem.data.repository;

import com.library.librarymanagesystem.data.models.Admin;
import com.library.librarymanagesystem.data.models.*;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findAdminById(Long id);
    Optional<Admin> findAdminByEmail(String email);
    void deleteAdminByEmail(String email);
}
