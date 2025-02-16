package com.example.board.controller;

import com.example.board.entity.FreeEntity;
import com.example.board.entity.NoticeEntity;
import com.example.board.service.FreeService;
import com.example.board.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/notification/notice")
public class NoticeController {

    private final NoticeService noticeService;

    // 게시글 작성
    @PostMapping("")
    public NoticeEntity createPost(@RequestBody NoticeEntity post) {
        return noticeService.createPost(post);
    }

    // 게시글 수정
    @PutMapping("/{id}")
    public NoticeEntity updatePost(@PathVariable Integer id, @RequestBody NoticeEntity post) {
        return noticeService.updatePost(id, post);
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer id) {
        noticeService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    // 개별 게시물 조회
    @GetMapping("/{id}")
    public NoticeEntity getPost(@PathVariable Integer id) {
        return noticeService.getPost(id);
    }

    // 모든 게시물 조회
    @GetMapping("")
    public List<NoticeEntity> getAllPosts() {
        return noticeService.getAllPosts();
    }
}
