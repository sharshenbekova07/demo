package com.example.demo.service;

import com.example.demo.dto.RegisterDto;
import com.example.demo.entity.User;

import java.util.List;

public interface AuthUserService {

    User registerUser(RegisterDto registerDto);

    User authenticate(String userName, String password);




}
