package com.library.librarymanagesystem.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Admin extends Details{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adminId", nullable = false)
    private Long adminId;
}
