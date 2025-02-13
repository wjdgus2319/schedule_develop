package com.example.schedules_develop.schedule.dto;

import lombok.Getter;

@Getter
public class UpdateContentsRequestDto {

    private final String oldContents;

    private final String newContents;

    public UpdateContentsRequestDto(String oldContents, String newContents){
        this.oldContents = oldContents;
        this.newContents = newContents;
    }
}
