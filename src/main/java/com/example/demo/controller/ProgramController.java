package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/system")
public class ProgramController {

    @GetMapping(value = "/exit")
    public void exit(){
        System.exit(1);
    }

    @GetMapping(value = "/help")
    public List<String>getAllCommand(){
        List<String>list=new ArrayList<>();
        list.add("exit");
        list.add("help");
        list.add("all_users");
        list.add("login");
        list.add("register");
        list.add("search_user_by_login");
        return list;
    }
}
