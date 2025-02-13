package com.example.board.controller;

import com.example.board.entity.FreeEntity;
import com.example.board.service.FreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user/post")
public class FreeController {

    private final FreeService freeService;

    // 게시글 작성
    @PostMapping("")
    public FreeEntity createPost(@RequestBody FreeEntity post) {
        return freeService.createPost(post);
    }

    // 게시글 수정
    @PutMapping("/{id}")
    public FreeEntity updatePost(@PathVariable Integer id, @RequestBody FreeEntity post) {
        return freeService.updatePost(id, post);
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer id) {
        freeService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    // 개별 게시물 조회
    @GetMapping("/{id}")
    public FreeEntity getPost(@PathVariable Integer id) {
        return freeService.getPost(id);
    }

    // 모든 게시물 조회
    @GetMapping("")
    public List<FreeEntity> getAllPosts() {
        return freeService.getAllPosts();
    }
}
