package org.example.easyhomesurvey.controller;

import org.example.easyhomesurvey.dto.AnswerDto;
import org.example.easyhomesurvey.dto.SurveyDto;
import org.example.easyhomesurvey.dto.SurveyResultDto;
import org.example.easyhomesurvey.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/survey")
public class SurveyController {
    @Autowired
    private SurveyService surveyService;

    // 설문 등록 - 관리자
    @PostMapping("/create")
    public ResponseEntity<String> createSurvey(@RequestBody SurveyDto surveyDto) {
        surveyService.createSurvey(surveyDto);
        return ResponseEntity.ok("설문조사 생성 완료");
    }

    // 설문 참여 - 입주민
    @PostMapping("/join")
    public ResponseEntity<String> joinSurvey(@RequestBody List<AnswerDto> answerDtos) {
        surveyService.joinSurvey(answerDtos);
        return ResponseEntity.ok("설문 참여 완료");
    }

    // 설문 결과 조회
    @GetMapping("/{surveyPk}")
    public SurveyResultDto getSurveyResults(@PathVariable Integer surveyPk) {
        return surveyService.getSurveyResults(surveyPk);
    }
}
