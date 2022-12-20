package com.library.librarymanagesystem.data.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    @Column(name = "isbn", nullable = false, unique = true)
    private String isbn;
    @ManyToOne
    private Author bookAuthor;
    private String bookTitle;
    private String yearPublished;
    @CreatedDate
    @Column(name="createdDate", nullable = false)
    private Instant createdDate = Instant.now();
    private Long availableQuantity;
}
