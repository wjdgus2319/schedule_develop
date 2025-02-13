package com.example.schedules_develop.schedule.entity;

import com.example.schedules_develop.common.entity.BaseEntity;
import com.example.schedules_develop.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    // columnDefinition = "longtext"**는 해당 컬럼의 데이터 타입을 LONGTEXT로 지정한다는 의미
    private String contents;

    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id")
    // Schedule이 User와 연결되어야 한다.
    private User user;

    public Schedule(){

    }

    public Schedule(String title, String contents){
        this.title = title;
        this.contents = contents;
    }

    public void updateContents(String contents){
        this.contents = contents;
    }
}
