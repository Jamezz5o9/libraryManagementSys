package com.library.librarymanagesystem.models;

import jakarta.persistence.*;
import lombok.experimental.SuperBuilder;

import java.util.*;

@Entity
@SuperBuilder
@Table(name = "baseUser")
public class Users extends Details{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id", nullable = false)
    private Long userId;
    @ManyToMany
    private List<Book> borrowedBooks = new ArrayList<>();
    @ManyToMany
    private List<BookRequest> bookRequests = new ArrayList<>();

}
