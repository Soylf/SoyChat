package com.example.SoyChat.back.repository;

import com.example.SoyChat.back.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Long> {
}
