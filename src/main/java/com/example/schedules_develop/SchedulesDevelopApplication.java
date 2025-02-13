package com.example.schedules_develop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SchedulesDevelopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulesDevelopApplication.class, args);
    }

}
