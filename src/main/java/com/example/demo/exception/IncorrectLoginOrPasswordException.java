package com.example.demo.exception;

public class IncorrectLoginOrPasswordException extends RuntimeException {

    public IncorrectLoginOrPasswordException(String message) {
        super(message);
    }
}
