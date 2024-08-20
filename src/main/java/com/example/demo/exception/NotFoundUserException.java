package com.example.demo.exception;

import com.example.demo.entity.User;

import java.util.List;

public class NotFoundUserException extends RuntimeException {
    public NotFoundUserException(String message) {
        super(message);
    }
}
