package org.example.easyhomesurvey.dto;

import lombok.Builder;
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

    // 여기에서도 managePk 삭제
    @Builder
    public SurveyDto(Integer managerPk, String title, String description, LocalDateTime endDate) {
        this.managerPk = managerPk;
        this.title = title;
        this.description = description;
        this.endDate = endDate;
    }
}
