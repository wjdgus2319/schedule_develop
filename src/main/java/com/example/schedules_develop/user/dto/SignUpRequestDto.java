package com.example.schedules_develop.user.dto;

import lombok.Getter;

@Getter

public class SignUpRequestDto {
    private final String username;

    private final String email;

    private final String password;

    public SignUpRequestDto(String userName, String email, String password) {
        this.username = userName;
        this.email = email;
        this.password = password;
    }
}
