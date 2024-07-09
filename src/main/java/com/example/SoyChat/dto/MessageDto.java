package com.example.SoyChat.dto;

import com.example.SoyChat.model.User;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {
    private Long id;
    private User user;
    @Size(max = 250, message = "Длина имени не больше 250-ти символов")
    private String text;
}
