package com.example.demo.service;

import com.example.demo.entity.Message;

import java.util.List;

public interface MessageService {

    List<Message> findAllMessages();

    void sendMessageToRecipient();


}
