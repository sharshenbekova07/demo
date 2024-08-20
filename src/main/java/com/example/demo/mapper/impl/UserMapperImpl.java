package com.example.demo.mapper.impl;

import com.example.demo.dto.RegisterDto;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {


    @Override
    public User registerDtoToUser(RegisterDto registerDto) {

        User user=new User();
        user.setUserName(registerDto.getUserName());
        user.setPassword(registerDto.getPassword());
        user.setPhoneNumber(registerDto.getPhoneNumber());
        return user;
    }
}
