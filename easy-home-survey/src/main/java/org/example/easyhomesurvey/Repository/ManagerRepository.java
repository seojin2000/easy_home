package org.example.easyhomesurvey.Repository;

import org.example.easyhomesurvey.entity.ManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<ManagerEntity, Integer> {
}
