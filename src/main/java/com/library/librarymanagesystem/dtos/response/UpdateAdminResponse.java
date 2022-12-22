package com.library.librarymanagesystem.dtos.response;

import lombok.Data;

@Data
public class UpdateAdminResponse {
    private final String status = "201";
    private final String message = "Admin updated succesfully";
    private String firstName;

}
