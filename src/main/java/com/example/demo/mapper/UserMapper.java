package com.example.demo.mapper;

import com.example.demo.dto.RegisterDto;
import com.example.demo.entity.User;

public interface UserMapper {
    User registerDtoToUser(RegisterDto registerDto);
}
