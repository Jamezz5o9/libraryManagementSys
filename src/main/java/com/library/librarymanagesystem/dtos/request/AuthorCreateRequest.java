package com.library.librarymanagesystem.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AuthorCreateRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
