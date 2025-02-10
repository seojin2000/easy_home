package org.example.easyhomesurvey.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
@NoArgsConstructor
public class SurveyDto {
    private Integer managerPk; // 추후 인증기능 추가 시 삭제
    private String title;
    private String description;
    private LocalDateTime endDate;
}
