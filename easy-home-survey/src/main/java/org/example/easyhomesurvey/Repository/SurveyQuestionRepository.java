package org.example.easyhomesurvey.Repository;

import org.example.easyhomesurvey.entity.SurveyQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyQuestionRepository extends JpaRepository<SurveyQuestion, Integer> {
}
