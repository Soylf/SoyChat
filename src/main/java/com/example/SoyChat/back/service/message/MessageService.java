package com.example.SoyChat.back.service.message;

import com.example.SoyChat.back.dto.MessageDto;

import java.util.List;

public interface MessageService {
    List<MessageDto> findAll();

    void create(MessageDto message);
}
