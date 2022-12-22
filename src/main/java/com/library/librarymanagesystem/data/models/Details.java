package com.library.librarymanagesystem.data.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Details {
    @Column(length = 50)
    private String firstName;
    @Column(length = 50)
    private String lastName;
    @Email
    @Column(unique = true, length = 255)
    private String email;
    @Column(length = 50)
    private String phoneNumber;
    @CreationTimestamp
    private Instant createdDate = Instant.now();
    @UpdateTimestamp
    private Instant modifiedDate = Instant.now();

}
