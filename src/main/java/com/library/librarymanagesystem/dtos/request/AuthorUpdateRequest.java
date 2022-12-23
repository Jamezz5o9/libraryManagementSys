package com.library.librarymanagesystem.dtos.request;

import lombok.Data;

@Data
public class AuthorUpdateRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
}
