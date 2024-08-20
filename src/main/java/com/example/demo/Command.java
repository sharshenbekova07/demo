package com.example.demo;

import com.example.demo.entity.User;

public interface Command {

    void execute();
    String description();

    boolean authUser();

}
