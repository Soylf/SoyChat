package com.example.SoyChat.back.dto;

import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {
    private Long id;
    @Size(max = 250, message = "Длина имени не больше 250-ти символов")
    private String text;
}
