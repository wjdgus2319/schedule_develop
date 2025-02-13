package com.example.schedules_develop.schedule.service;


import com.example.schedules_develop.schedule.dto.ScheduleResponseDto;
import com.example.schedules_develop.schedule.repository.ScheduleRepository;
import com.example.schedules_develop.user.repository.UserRepository;
import com.example.schedules_develop.schedule.entity.Schedule;
import com.example.schedules_develop.user.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;

    // 일정 생성
    public ScheduleResponseDto save(String title, String contents, String username){

        User findUser = userRepository.findUserByUserNameOrElseThrow(username);

        Schedule schedule = new Schedule(title, contents);
        schedule.setUser(findUser);

        scheduleRepository.save(schedule);

        return new ScheduleResponseDto(schedule.getId(), schedule.getTitle(), schedule.getContents());
    }

    // 일정 조회
    public List<ScheduleResponseDto> findAll() {
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }

    // 일정 수정
    @Transactional
    public void updateContents(Long id, String oldContents, String newContents){

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        if(!findSchedule.getContents().equals(oldContents)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "일정 내용이 일치하지 않습니다.");
        }

        findSchedule.updateContents(newContents);
    }


    // 일정 삭제
    public void delete(Long id){

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        scheduleRepository.delete(findSchedule);
    }
}
