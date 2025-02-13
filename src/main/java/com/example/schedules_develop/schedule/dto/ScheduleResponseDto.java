package com.example.schedules_develop.schedule.dto;


import com.example.schedules_develop.schedule.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {

    private final Long id;

    private final String title;

    private final String contents;

    public ScheduleResponseDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }

    public static ScheduleResponseDto toDto(Schedule schedule){
        return new ScheduleResponseDto(schedule.getId(), schedule.getTitle(), schedule.getContents());
    }
}
