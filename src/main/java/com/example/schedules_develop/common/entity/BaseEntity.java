package com.example.schedules_develop.common.entity;


import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    // 여러 엔티티가 공통적으로 가져야 할 속성을 상속받아 재사용하는 구조를 제공해준다.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // GeneratedValue : 엔티티의 기본 키 값이 자동으로 생성되도록 지정하는 어노테이션
    // strategy = GenerationType.IDENTITY : 기본 키의 값을 자동 증가 방식으로 생성할 것을 지정
    // 데이터베이스에서 AUTO_INCREMENT 같은 방식
    private Long id;  // 모든 엔티티가 공통으로 가질 ID

    @CreatedDate
    @Column(updatable = false)
    // 생성 일자
    private LocalDateTime createdAt;

    // 수정 일자
    @LastModifiedDate
    private LocalDateTime modifiedAt;
}
