package com.library.librarymanagesystem.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class BookRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreatedDate
    @Column(name="createdDate", nullable = false)
    private Instant createdDate = Instant.now();
    @LastModifiedDate
    @Column(name="lastModifiedDate")
    private Instant modifiedDate = Instant.now();
    @ManyToOne
    private Users user;
}
