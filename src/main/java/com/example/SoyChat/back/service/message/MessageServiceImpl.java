package com.example.SoyChat.back.service.message;

import com.example.SoyChat.back.dto.MessageDto;
import com.example.SoyChat.back.mapper.MessageMapper;
import com.example.SoyChat.back.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
//@AllArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    @Override
    public List<MessageDto> findAll() {
        return MessageMapper.MAPPER.toDtоs(messageRepository.findAll());
    }

    @Transactional
    @Override
    public void create(MessageDto message) {
        messageRepository.save(MessageMapper.MAPPER.fromDto(message));
    }
}