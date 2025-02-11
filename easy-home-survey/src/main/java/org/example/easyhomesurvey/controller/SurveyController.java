package org.example.easyhomesurvey.controller;

import org.example.easyhomesurvey.dto.SurveyDto;
import org.example.easyhomesurvey.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/survey")
public class SurveyController {
    @Autowired
    private SurveyService surveyService;

    // 설문 등록
    @PostMapping("/create")
    public ResponseEntity<String> createSurvey(@RequestBody SurveyDto surveyDto) {
        surveyService.createSurvey(surveyDto);
        return ResponseEntity.ok("설문조사 생성 완료");
    }


    // 설문 참여
    // 설문 결과 조회
}
