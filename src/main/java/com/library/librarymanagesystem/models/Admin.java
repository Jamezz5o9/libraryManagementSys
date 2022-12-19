package com.library.librarymanagesystem.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
public class Admin extends Details{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "adminId", nullable = false)
    private Long adminId;
}
