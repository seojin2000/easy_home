package org.example.easyhomesurvey.service;

import org.example.easyhomesurvey.Repository.ManagerRepository;
import org.example.easyhomesurvey.Repository.SurveyQuestionRepository;
import org.example.easyhomesurvey.Repository.SurveyRepository;
import org.example.easyhomesurvey.dto.QuestionDto;
import org.example.easyhomesurvey.dto.SurveyDto;
import org.example.easyhomesurvey.entity.ManagerEntity;
import org.example.easyhomesurvey.entity.SurveyEntity;
import org.example.easyhomesurvey.entity.SurveyQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyService {
    @Autowired
    private SurveyRepository surveyRepository;
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private SurveyQuestionRepository surveyQuestionRepository;

    // 설문 등록
    public void createSurvey(SurveyDto surveyDto) {
        // 관리자번호가 없거나 존재하지 않으면 안됨 (인증 후 수정)
        if (surveyDto.getManagerPk() == null) {
            throw new IllegalArgumentException("ManagerPk is null");
        }
        ManagerEntity manager = managerRepository.findById(surveyDto.getManagerPk())
                .orElseThrow(() -> new IllegalArgumentException("Manager does not exist"));

        // title이 비면 안됨
        if (surveyDto.getTitle() == null || surveyDto.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        // title 중복 여부 확인
        if (surveyRepository.findByTitle(surveyDto.getTitle()).isPresent()) {
            throw new IllegalArgumentException("Title already exists");
        }
        // 설문  생성
        SurveyEntity surveyEntity = new SurveyEntity();
        surveyEntity.setManager(manager);
        surveyEntity.setTitle(surveyDto.getTitle());
        surveyEntity.setDescription(surveyDto.getDescription());
        surveyEntity.setEndDate(surveyDto.getEndDate());
        surveyRepository.save(surveyEntity);

        // 질문 리스트 저장
        List<QuestionDto> questions = surveyDto.getQuestions();
        for (QuestionDto questionDto : questions) {
            SurveyQuestion questionEntity = new SurveyQuestion();
            questionEntity.setQuestion(questionDto.getQuestion());
            questionEntity.setSurvey(surveyEntity);
            surveyQuestionRepository.save(questionEntity);
        }
    }
    // 설문 참여
    // 설문 결과 조회
}
