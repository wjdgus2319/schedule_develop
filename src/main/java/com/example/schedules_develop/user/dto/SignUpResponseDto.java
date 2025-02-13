package com.example.schedules_develop.user.dto;

import com.example.schedules_develop.user.entity.User;
import lombok.Getter;

@Getter
public class SignUpResponseDto {

    private final Long id;

    private final String title;

    private final String content;

    public SignUpResponseDto(Long id, String title, String content, String password, String userPassword) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public static SignUpResponseDto userDto(User user){
        return new SignUpResponseDto(user.getId(),user.getUserName(), user.getEmail(), user.getEmail(), user.getPassword());
    }
}
