package com.example.schedules_develop.user.controller;


import com.example.schedules_develop.user.dto.LoginRequestDto;
import com.example.schedules_develop.user.dto.SignUpRequestDto;
import com.example.schedules_develop.user.dto.SignUpResponseDto;
import com.example.schedules_develop.user.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    // 회원 생성 기능
    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto){

        SignUpResponseDto signUpResponseDto =
        userService.signUp(
                requestDto.getUsername(),
                requestDto.getEmail(),
                requestDto.getPassword()
        );

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

    // 회원 조회 기능
    @GetMapping
    public ResponseEntity<List<SignUpResponseDto>> findAll() {

        List<SignUpResponseDto> signUpResponseDtoList = userService.findAll();

        return new ResponseEntity<>(signUpResponseDtoList, HttpStatus.OK);
    }


    // 회원 삭제 기능
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        userService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
