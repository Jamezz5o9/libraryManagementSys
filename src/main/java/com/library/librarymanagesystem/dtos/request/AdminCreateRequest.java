package com.library.librarymanagesystem.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AdminCreateRequest {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phoneNumber;
}
