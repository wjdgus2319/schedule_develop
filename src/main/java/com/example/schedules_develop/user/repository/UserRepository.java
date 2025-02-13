package com.example.schedules_develop.user.repository;

import com.example.schedules_develop.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUserName(String username);

    default User findUserByUserNameOrElseThrow(String username){
        return findUserByUserName(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist username = " + username));
    }

    default User findByIdOrElseThrow(Long id){
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id));
    }

    // 로그인
    Optional<User> findByEmail(String email);

    //email 일치하지 않을 경우 예외처리
    default User findByEmailOrElseThrow(String email){
        return findByEmail(email).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "이메일이 일치하지 않습니다."));
    }
}
