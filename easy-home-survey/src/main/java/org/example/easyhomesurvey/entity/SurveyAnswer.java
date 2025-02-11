package org.example.easyhomesurvey.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="survey_answer")
@NoArgsConstructor
public class SurveyAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer answerPk;

    // 인증 기능 추가 시 외래키 삭제
    // private Integer surveyPk;
    @ManyToOne
    @JoinColumn(name="question_pk", nullable=false)
    private SurveyQuestion question;

    // 인증 기능 추가 시 외래키 삭제
    // private Integer userPk;
    @ManyToOne
    @JoinColumn(name="user_pk", nullable=false)
    private UserEntity user;

    private String answer;
}
