package com.example.schedules_develop.user.dto;

import lombok.Getter;

@Getter
public class UserResponseDto {

    private final String username;
    private final String email;

    public UserResponseDto(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
