package com.library.librarymanagesystem.dtos.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
public class AdminCreateResponse {
    private String email;
    private final String message = "Successful";
    @JsonIgnore
    private Long id;
    private String firstName;

}
