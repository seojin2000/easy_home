package com.example.chatservice.member.config;

import com.example.chatservice.member.entity.Member;
import com.example.chatservice.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;
import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class InitialDataConfig {
    private final MemberRepository memberRepository;

    @PostConstruct
    public void init() {
        if (memberRepository.count() == 0) {
            memberRepository.saveAll(Arrays.asList(
                    Member.builder().userPk(1L).nickname("사용자1").build(),
                    Member.builder().userPk(2L).nickname("사용자2").build()
            ));
        }
    }
}