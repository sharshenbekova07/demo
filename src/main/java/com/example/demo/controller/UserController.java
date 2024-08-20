package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "Пользователи в системе ")
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(
            summary = "Формат вывода данных о всех пользователях системы",
            description = "Вывод всех пользователей в системе "
    )
    @GetMapping(value = "/all-users")
    public ResponseEntity<?> getAllUsers() {
        List<User> allUsers = userService.findAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(allUsers);
    }
}
