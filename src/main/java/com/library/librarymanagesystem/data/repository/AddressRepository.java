package com.library.librarymanagesystem.data.repository;

import com.library.librarymanagesystem.data.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
