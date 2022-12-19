package com.library.librarymanagesystem.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorCreateResponse {
    private Long id;
    private String password;
    private String email;
    private String lastName;
    private String firstName;
}
