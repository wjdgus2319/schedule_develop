package com.example.schedules_develop.user.controller;

import com.example.schedules_develop.user.dto.LoginRequestDto;
import com.example.schedules_develop.user.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    //로그인 기능
    @PostMapping("/login")
    public ResponseEntity<Void> login(
            @RequestBody LoginRequestDto requestDto,
            HttpServletRequest request
    ){
        loginService.login(
                requestDto.getEmail(),
                requestDto.getPassword()
        );
        // 로그인 성공
        // Session이 request에 존재하면 기존의 Session을 반환하고, 없을 경우에 새로 Session을 생성한다.
        HttpSession session = request.getSession(true);

        // Session에 로그인 회원 정보를 저장
        session.setAttribute("email", requestDto.getEmail());
        return new ResponseEntity<>(HttpStatus.OK);
        //성공하면 OK 반환
    }
}
