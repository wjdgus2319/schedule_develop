package com.example.schedules_develop.user.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;
import jakarta.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class LoginRequestDto {

    @NotBlank
    private final String email;

    @NotNull
    private final String password;

}
