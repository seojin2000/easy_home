package org.example.easyhomesurvey.Repository;

import org.example.easyhomesurvey.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
