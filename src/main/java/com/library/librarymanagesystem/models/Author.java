package com.library.librarymanagesystem.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
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
