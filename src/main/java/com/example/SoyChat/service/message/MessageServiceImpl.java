package com.example.SoyChat.service.message;

import com.example.SoyChat.dto.MessageDto;
import com.example.SoyChat.error.exception.NotFoundException;
import com.example.SoyChat.mapper.MessageMapper;
import com.example.SoyChat.repository.MessageRepository;
import com.example.SoyChat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    @Override
    public List<MessageDto> findAll() {
        return List.of();
    }

    @Transactional
    public void create(MessageDto message) {
        checkUser(message.getUser().getId());
        messageRepository.save(MessageMapper.MAPPER.toDto(message));
    }

    private void checkUser(Long userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(String.format("Пользователь с id: '%s' не найден", userId)));
    }
}
