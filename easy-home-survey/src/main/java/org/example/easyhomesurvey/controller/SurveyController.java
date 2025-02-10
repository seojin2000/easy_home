package org.example.easyhomesurvey.controller;

import org.example.easyhomesurvey.service.SurveyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/survey")
public class SurveyController {
    // 설문 등록
    @PostMapping("/create")
    public ResponseEntity<String> createSurvey() {
        return ResponseEntity.ok("설문조사 생성 완료");
    }

    // 실문 질문 증록

    // 설문 참여
    // 설문 결과 조회
}
