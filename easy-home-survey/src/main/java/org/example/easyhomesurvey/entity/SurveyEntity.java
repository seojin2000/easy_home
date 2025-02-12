package org.example.easyhomesurvey.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="survey")
@Data
@NoArgsConstructor
public class SurveyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer surveyPk;

    // 인증 기능 추가 시 외래키 삭제
    // private Integer managerPk;
    @ManyToOne
    @JoinColumn(name="manager_pk", nullable=false)
    private ManagerEntity manager;

    private String title;
    private String description;
    private LocalDateTime endDate;

    // 질문
    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SurveyQuestion> questions;
}
