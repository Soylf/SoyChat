package com.example.SoyChat.back.controller;

import com.example.SoyChat.back.dto.MessageDto;
import com.example.SoyChat.back.service.message.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private MessageService service;

    @GetMapping
    public List<MessageDto> getAll() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody MessageDto message) {
        log.info("Текст -> {}", message.getText());
        service.create(message);
        return ResponseEntity.ok().build();
    }
}
