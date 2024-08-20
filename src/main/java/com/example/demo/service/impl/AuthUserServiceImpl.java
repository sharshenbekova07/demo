package com.example.demo.service.impl;

import com.example.demo.dto.RegisterDto;
import com.example.demo.entity.User;
import com.example.demo.exception.IncorrectLoginOrPasswordException;
import com.example.demo.exception.IncorrectPasswordException;
import com.example.demo.exception.RegisteredUserException;
import com.example.demo.exception.UserNotExistException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.AuthUserRepository;
import com.example.demo.service.AuthUserService;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthUserServiceImpl implements AuthUserService {

    private final AuthUserRepository authUserRepository;
    private final UserService userService;

    private final UserMapper userMapper;

    public AuthUserServiceImpl(AuthUserRepository authUserRepository, UserService userService, UserMapper userMapper) {
        this.authUserRepository = authUserRepository;
        this.userService = userService;
        this.userMapper = userMapper;
    }

    public User registerUser(RegisterDto registerDto) {

        User existUser = (authUserRepository.findByUserName(registerDto.getUserName()));

        if (existUser != null) {
            throw new RegisteredUserException("Пользователь с таким логином уже зарегистрирован в системе !");
        }
        if (!registerDto.getPassword().equals(registerDto.getConfirmPassword())) {
            throw new IncorrectPasswordException("Пароли не совпадают");
        }
        if (registerDto.getPhoneNumber() == null || registerDto.getPhoneNumber().isBlank()) {
            throw new NullPointerException("Поле номер телефона не может быть пустым !");
        }
        Optional<User> userCheckByNumber = userService.findByPhoneNumber(registerDto.getPhoneNumber());
        if (userCheckByNumber.isPresent()) {
            throw new RegisteredUserException("Пользователь с таким номером телефона уже есть в системе");
        }

        User user = userMapper.registerDtoToUser(registerDto);

        return authUserRepository.save(user);
    }

    @Override
    public User authenticate(String userName, String password) {

        User existUser = authUserRepository.findByUserName(userName);
        if (existUser == null) {
            throw new UserNotExistException("Такого пользователя нет в системе !");
        }
        if (existUser.getUserName() != null && existUser.getUserName().equals(userName) && existUser.getPassword().equals(password)) {
            return existUser;
        } else if (existUser.getUserName() != null && !existUser.getUserName().equals(userName) || !existUser.getPassword().equals(password)) {
            throw new IncorrectLoginOrPasswordException("Неверный логин или пароль !");
        }
        return existUser;

    }
}
