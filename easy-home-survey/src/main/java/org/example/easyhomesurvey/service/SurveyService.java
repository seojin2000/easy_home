package org.example.easyhomesurvey.service;

import org.example.easyhomesurvey.Repository.*;
import org.example.easyhomesurvey.dto.AnswerDto;
import org.example.easyhomesurvey.dto.QuestionDto;
import org.example.easyhomesurvey.dto.SurveyDto;
import org.example.easyhomesurvey.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyService {
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SurveyRepository surveyRepository;
    @Autowired
    private SurveyQuestionRepository surveyQuestionRepository;
    @Autowired
    private SurveyAnswerRepository surveyAnswerRepository;

    // 설문 등록 - 관리자
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
            // 최소 1개의 질문이 있어야함
        if (questions == null || questions.isEmpty()) {
            throw new IllegalArgumentException("At least one question must be provided");
        }
        for (QuestionDto questionDto : questions) {
            SurveyQuestion questionEntity = new SurveyQuestion();
            questionEntity.setQuestion(questionDto.getQuestion());
            questionEntity.setSurvey(surveyEntity);
            surveyQuestionRepository.save(questionEntity);
        }
    }
    // 설문 참여 - 입주민
    public void joinSurvey(List<AnswerDto> answerDtos) {
        for (AnswerDto answerDto : answerDtos) {
            // 회원번호가 없거나 존재하지 않으면 안됨(인증 후 수정)
            if (answerDto.getUserPk() == null) {
                throw new IllegalArgumentException("userPk is null");
            }
            UserEntity user = userRepository.findById(answerDto.getUserPk())
                    .orElseThrow(() -> new IllegalArgumentException("User does not exist"));

            // questionPk가 없거나 존재하지 않으면 안됨
            if (answerDto.getQuestionPk() == null) {
                throw new IllegalArgumentException("questionPk is null");
            }
            SurveyQuestion question = surveyQuestionRepository.findById(answerDto.getQuestionPk())
                    .orElseThrow(() -> new IllegalArgumentException("Question does not exist"));

            // answer가 비면 안됨
            if (answerDto.getAnswer() == null || answerDto.getAnswer().isEmpty()) {
                throw new IllegalArgumentException("Answer cannot be null or empty");
            }

            // 답변 생성
            SurveyAnswer surveyAnswer = new SurveyAnswer();
            surveyAnswer.setUser(user);
            surveyAnswer.setQuestion(question);
            surveyAnswer.setAnswer(answerDto.getAnswer());
            surveyAnswerRepository.save(surveyAnswer);
        }
    }

    // 설문 결과 조회
}
