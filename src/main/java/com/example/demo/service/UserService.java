package com.example.demo.service;

import com.example.demo.dto.RegisterDto;
import com.example.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

 List<User> findAllUsers();

 Optional< User> findByPhoneNumber(String phoneNumber);







}
