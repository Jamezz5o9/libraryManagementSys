package com.library.librarymanagesystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AuthorException.class)
    public ResponseEntity<?> handleAuthorErrorEx(AuthorException ex, WebRequest request){
        ApiErrorDetails apiErrorDetails = new ApiErrorDetails(ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(apiErrorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AdminException.class)
    public ResponseEntity<?> handleAdminErrorEx(AdminException ex, WebRequest request){
        ApiErrorDetails apiErrorDetails = new ApiErrorDetails(ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(apiErrorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LoginDetailsException.class)
    public ResponseEntity<?> handleLoginErrorEx(LoginDetailsException ex, WebRequest request){
        ApiErrorDetails apiErrorDetails = new ApiErrorDetails(ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(apiErrorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookException.class)
    public ResponseEntity<?> handleBookErrorEx(BookException ex, WebRequest request){
        ApiErrorDetails apiErrorDetails = new ApiErrorDetails(ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(apiErrorDetails, HttpStatus.NOT_FOUND);
    }
}
