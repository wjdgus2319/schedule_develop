package com.example.schedules_develop.user.service;


import com.example.schedules_develop.user.dto.SignUpResponseDto;
import com.example.schedules_develop.user.repository.UserRepository;
import com.example.schedules_develop.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    // 유저 생성
    public SignUpResponseDto signUp(String username, String email, String password){

        User user = new User(username, email, password);

        User savedUser = userRepository.save(user);

        return new SignUpResponseDto(savedUser.getId(), savedUser.getUserName(), savedUser.getEmail(), savedUser.getPassword(), user.getPassword());

    }

    // 유저 조회
    public List<SignUpResponseDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(SignUpResponseDto::userDto)
                .toList();
    }

    // 유저 삭제
    public void delete(Long id) {

        User findUser = userRepository.findByIdOrElseThrow(id);

        userRepository.delete(findUser);
    }
}
