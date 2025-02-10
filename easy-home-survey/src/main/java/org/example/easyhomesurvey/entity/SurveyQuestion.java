package org.example.easyhomesurvey.entity;

import jakarta.persistence.*;

public class SurveyQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer survey_pk;

    // 인증 기능 추가 시 외래키 삭제
    // private Integer surveyPk;
    @ManyToOne
    @JoinColumn(name="survey_pk", nullable=false)
    private SurveyEntity survey;

    private String question;
    private String answer;
}
