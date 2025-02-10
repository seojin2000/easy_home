package org.example.easyhomesurvey.Repository;

import org.example.easyhomesurvey.entity.SurveyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<SurveyEntity, Integer> {
}
