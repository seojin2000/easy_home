package com.example.board.repository;

import com.example.board.entity.FreeEntity;
import com.example.board.entity.NoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<NoticeEntity, Integer> {
}
