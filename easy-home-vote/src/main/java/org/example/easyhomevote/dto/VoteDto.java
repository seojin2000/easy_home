package org.example.easyhomevote.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
public class VoteDto {
    private Integer managerPk; // 추후 인증기능 추가 시 삭제
    private String title;
    private String description;
    private LocalDateTime endDate;

    // 선택지 리스트
    private List<OptionDto> options;
}
