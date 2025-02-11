package org.example.easyhomesurvey.Repository;

import org.example.easyhomesurvey.entity.SurveyAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyAnswerRepository extends JpaRepository<SurveyAnswer, Integer> {
}
