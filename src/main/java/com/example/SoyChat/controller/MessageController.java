package com.example.SoyChat.controller;

import com.example.SoyChat.dto.MessageDto;
import com.example.SoyChat.service.message.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService service;

    @GetMapping
    public List<MessageDto> getAll() {
        return service.findAll();
    }

    @PostMapping
    public void create(@RequestBody MessageDto message) {
        service.create(message);
    }
}
