package org.example.easyhomesurvey.service;

import org.example.easyhomesurvey.Repository.ManagerRepository;
import org.example.easyhomesurvey.Repository.SurveyRepository;
import org.example.easyhomesurvey.dto.SurveyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyService {
    @Autowired
    private SurveyRepository surveyRepository;
    @Autowired
    private ManagerRepository managerRepository;

    // 설문 등록
    public void createSurvey(SurveyDto surveyDto) {
        // 1. title 겹친다면 이미 있는 설문입니다.

        // title 없다면 있어야한다고 한다

        // 2. 설문 객체 생성
        // 3. 요소 4개 추가
        // 4. save
    }
    // 설문 참여
    // 설문 결과 조회
}
