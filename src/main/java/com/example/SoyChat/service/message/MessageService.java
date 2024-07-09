package com.example.SoyChat.service.message;

import com.example.SoyChat.dto.MessageDto;

import java.util.List;

public interface MessageService {
    List<MessageDto> findAll();

    void create(MessageDto message);
}
