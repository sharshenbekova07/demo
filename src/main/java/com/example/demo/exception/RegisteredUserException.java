package com.example.demo.exception;

public class RegisteredUserException extends  RuntimeException {
    public RegisteredUserException(String message) {
        super(message);
    }
}
