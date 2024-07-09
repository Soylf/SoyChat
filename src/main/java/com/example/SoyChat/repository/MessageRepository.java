package com.example.SoyChat.repository;

import com.example.SoyChat.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Long> {
}
