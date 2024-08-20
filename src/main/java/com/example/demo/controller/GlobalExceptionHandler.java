package com.example.demo.controller;

import com.example.demo.exception.IncorrectLoginOrPasswordException;
import com.example.demo.exception.IncorrectPasswordException;
import com.example.demo.exception.RegisteredUserException;
import com.example.demo.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseStatus
public class GlobalExceptionHandler {


    @ExceptionHandler(RegisteredUserException.class)
    public ResponseEntity<String> handleException(RegisteredUserException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());

    }

    @ExceptionHandler(UserNotExistException.class)
    public ResponseEntity<String> handleException(UserNotExistException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }

    @ExceptionHandler(IncorrectLoginOrPasswordException.class)
    public ResponseEntity<String> handleException(IncorrectLoginOrPasswordException ex) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(ex.getMessage());
    }

    @ExceptionHandler(IncorrectPasswordException.class)
    public ResponseEntity<String> handleException(IncorrectPasswordException ex) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(ex.getMessage());
    }



}
