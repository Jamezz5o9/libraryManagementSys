package com.library.librarymanagesystem.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private final String message = "Login successful";
    private String firstName;
    private String lastName;
}
