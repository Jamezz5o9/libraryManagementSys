package com.library.librarymanagesystem.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrorDetails {
    private String message;
    private String details;
    private LocalDateTime timeStamp;

    public ApiErrorDetails(String message, String details){
        this.message = message;
        this.details = details;
        this.timeStamp = LocalDateTime.now();
    }
}
