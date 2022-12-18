package com.library.librarymanagesystem.models;

import com.library.librarymanagesystem.enums.BorrowedBookStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class BorrowedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BorrowedId", nullable = false)
    private Long id;

    private BorrowedBookStatus borrowedBookStatus;
}
