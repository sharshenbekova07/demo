package com.example.demo.controller;

import com.example.demo.dto.RegisterDto;
import com.example.demo.entity.User;
import com.example.demo.service.AuthUserService;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Контроллер для авторизации и аутентификации пользователей")
@RestController
@RequestMapping(value = "/api/auth")
public class AuthenticationController {

    private final AuthUserService authUserService;
    private final UserService userService;

    public AuthenticationController(AuthUserService authUserService, UserService userService) {
        this.authUserService = authUserService;
        this.userService = userService;
    }

    @Operation(
            summary = "Pегистрация ",
            description = "регистрация пользователя в систему "
    )
    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody RegisterDto registerDto){
        User user=authUserService.registerUser(registerDto);
     return ResponseEntity.status(HttpStatus.CREATED).body("Вы успешно зарегистрированы в систему !");

    }

    @Operation(
            summary = "Аутентификация пользователя в системе"
    )
    @GetMapping(value = "/login")
    public ResponseEntity<?>authorizationUser(@RequestParam String userName,
                                              @RequestParam String password){

        User user=authUserService.authenticate(userName,password);
        return ResponseEntity.status(HttpStatus.OK).body("Добро пожадовать в систему : " + user.getUserName());
    }

    @Operation(
            summary = "Вывод данных о пользователе",
            description = "Вывод информации  о автортзованном пользователе"
    )
    @GetMapping(value = "/info")
    public ResponseEntity<?>getAuthUser(String userName,String password){
        User user=authUserService.authenticate(userName,password);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}




