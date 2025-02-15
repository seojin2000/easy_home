package com.example.chatservice.member.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    private Long userPk;
    private String nickname;
    private LocalDateTime createdAt;

    @Builder
    public Member(Long userPk, String nickname) {
        this.userPk = userPk;
        this.nickname = nickname;
        this.createdAt = LocalDateTime.now();
    }
}