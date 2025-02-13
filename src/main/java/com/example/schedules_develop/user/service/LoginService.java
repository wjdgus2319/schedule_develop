package com.example.schedules_develop.user.service;

import com.example.schedules_develop.user.entity.User;
import com.example.schedules_develop.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    //로그인
    public void login(String email, String password) {
        // 입력받은 email & 비밀번호와 일치하는 Database 조회
        User user = userRepository.findByEmailOrElseThrow(email);

        //password 일치하지 않으면 true
        if(!user.getPassword().equals(password)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다.");
        }
    }

}
