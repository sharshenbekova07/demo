package com.example.demo.commands;

import com.example.demo.Command;
import com.example.demo.dto.RegisterDto;
import com.example.demo.entity.User;
import com.example.demo.exception.RegisteredUserException;
import com.example.demo.service.AuthUserService;

public class Register implements Command {

    private final String commandName="register";

    private final AuthUserService authUserService;

    public Register(AuthUserService authUserService) {
        this.authUserService = authUserService;
    }

    @Override
    public void execute() {

    }

    @Override
    public String description() {
        return "Регистрация пользователя в системе";
    }

    @Override
    public boolean authUser() {

        return false;
    }
}
