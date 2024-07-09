package com.example.SoyChat.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    @Size(min = 3, max = 50, message = "Длина имени должна быть 3 - 50 символов")
    @NotBlank(message = "Имя не может быть пустым или отсутствовать")
    private String name;
}