package com.library.librarymanagesystem.dtos.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AuthorCreateResponse {
    private String email;
    @JsonIgnore
    private Long id;
    private String message = "Author created succesfully";

}
