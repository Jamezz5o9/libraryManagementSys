package com.library.librarymanagesystem.data.repository;

import com.library.librarymanagesystem.data.models.Users;
import com.library.librarymanagesystem.data.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
