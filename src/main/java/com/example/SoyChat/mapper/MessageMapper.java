package com.example.SoyChat.mapper;

import com.example.SoyChat.dto.MessageDto;
import com.example.SoyChat.model.Message;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MessageMapper {
    MessageMapper MAPPER = Mappers.getMapper(MessageMapper.class);
    Message toDto(MessageDto messageDto);
}
