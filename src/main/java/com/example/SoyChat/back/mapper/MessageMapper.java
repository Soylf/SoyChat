package com.example.SoyChat.back.mapper;

import com.example.SoyChat.back.dto.MessageDto;
import com.example.SoyChat.back.model.Message;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MessageMapper {
    MessageMapper MAPPER = Mappers.getMapper(MessageMapper.class);
    Message fromDto(MessageDto messageDto);
    MessageDto toDto(Message message);
    List<MessageDto> toDtоs(List<Message> messages);
}
