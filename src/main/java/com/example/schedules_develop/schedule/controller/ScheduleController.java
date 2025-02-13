package com.example.schedules_develop.schedule.controller;


import com.example.schedules_develop.schedule.dto.ScheduleRequestDto;
import com.example.schedules_develop.schedule.dto.ScheduleResponseDto;
import com.example.schedules_develop.schedule.dto.UpdateContentsRequestDto;
import com.example.schedules_develop.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    // 일정 생성
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody ScheduleRequestDto requestDto){

        ScheduleResponseDto scheduleResponseDto =
                scheduleService.save(
                        requestDto.getTitle(),
                        requestDto.getContents(),
                        requestDto.getUsername()
                );
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }

    // 일정 조회
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll() {

        List<ScheduleResponseDto> scheduleResponseDtoList = scheduleService.findAll();

        return new ResponseEntity<>(scheduleResponseDtoList, HttpStatus.OK);

    }

    // 일정 수정
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateContents(
            @PathVariable Long id,
            @RequestBody UpdateContentsRequestDto requestDto
    ){

        scheduleService.updateContents(id, requestDto.getOldContents(), requestDto.getNewContents());

        return new ResponseEntity<>(HttpStatus.OK);
    }


    // 일정 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        scheduleService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}