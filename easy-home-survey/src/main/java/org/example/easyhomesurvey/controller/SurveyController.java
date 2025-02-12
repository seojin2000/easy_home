package org.example.easyhomesurvey.controller;

import org.example.easyhomesurvey.dto.*;
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
    @PostMapping("")
    public ResponseEntity<String> createSurvey(@RequestBody SurveyDto surveyDto) {
        surveyService.createSurvey(surveyDto);
        return ResponseEntity.ok("설문조사 생성 완료");
    }

    // 설문 참여 - 입주민
    @PostMapping("/join")
    public ResponseEntity<String> joinSurvey(@RequestBody List<AnswerDto> answerDtos) {
        surveyService.joinSurvey(answerDtos);
        return ResponseEntity.ok("설문조사 참여 완료");
    }

    // 설문 결과 조회
    @GetMapping("/{surveyPk}")
    public SurveyResultDto getSurveyResults(@PathVariable Integer surveyPk) {
        return surveyService.getSurveyResults(surveyPk);
    }

    // 설문 수정
    @PutMapping("/{surveyPk}")
    public ResponseEntity<SurveyUpdateResDto> updateSurvey(
            @PathVariable Integer surveyPk,
            @RequestBody SurveyUpdateReqDto requestDto) {
        SurveyUpdateResDto updatedSurvey = surveyService.updateSurvey(surveyPk, requestDto);
        return ResponseEntity.ok(updatedSurvey);
    }

    // 질문 추가

    // 질문 수정

    // 질문 삭제

    // 설문 삭제
    @DeleteMapping("/{surveyPk}")
    public ResponseEntity<String> deleteSurvey(@PathVariable Integer surveyPk) {
        surveyService.deleteSurvey(surveyPk);
        return ResponseEntity.ok("설문조사 삭제 완료");
    }
}
