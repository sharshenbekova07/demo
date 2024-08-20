package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/message")
public class MessageController {

    @GetMapping(value = "/get-all")
    public ResponseEntity getAllMessages(){
        return ResponseEntity.ok("Весь список сообщений ");
    }

    @PostMapping(value = "/send_message")
    public ResponseEntity sendMessage(@RequestBody String message){
        return ResponseEntity.ok("Пришло на сервер "+message);
    }
}
