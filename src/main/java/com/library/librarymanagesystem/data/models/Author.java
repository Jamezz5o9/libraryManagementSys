package com.library.librarymanagesystem.data.models;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Author extends Details{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BorrowedId", nullable = false)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();
    @CreatedDate
    @Column(name="created_time", nullable = false)
    private Instant createdDate = Instant.now();
    @LastModifiedDate
    @Column(name="modified_date")
    private Instant modifiedDate = Instant.now();

}
