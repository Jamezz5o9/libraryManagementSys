package com.library.librarymanagesystem.data.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private Long isbn;
    @ManyToMany
    private List<Author> bookAuthor = new ArrayList<>();
    private String title;
    @CreatedDate
    private Instant createdDate = Instant.now();
    private String yearPublished;
    private Long availableQuantity;
}
