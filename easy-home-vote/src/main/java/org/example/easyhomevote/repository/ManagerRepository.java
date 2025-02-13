package org.example.easyhomevote.repository;

import org.example.easyhomevote.entity.ManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<ManagerEntity, Integer> {
}
