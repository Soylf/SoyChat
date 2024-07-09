package com.example.SoyChat.repository;

import com.example.SoyChat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
