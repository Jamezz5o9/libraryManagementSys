package com.library.librarymanagesystem.data.models;

import jakarta.persistence.*;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
public class Admin extends Details{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "adminId", nullable = false)
    private Long adminId;
}
