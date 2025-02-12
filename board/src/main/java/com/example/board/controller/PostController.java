package com.example.board.controller;

import com.example.board.entity.PostEntity;
import com.example.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    // 게시글 작성
    @PostMapping("")
    public PostEntity createPost(@RequestBody PostEntity post) {
        return postService.createPost(post);
    }

    // 게시글 수정
    @PutMapping("/{id}")
    public PostEntity updatePost(@PathVariable Integer id, @RequestBody PostEntity post) {
        return postService.updatePost(id, post);
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    // 개별 게시물 조회
    @GetMapping("/{id}")
    public PostEntity getPost(@PathVariable Integer id) {
        return postService.getPost(id);
    }

    // 모든 게시물 조회
    @GetMapping("")
    public List<PostEntity> getAllPosts() {
        return postService.getAllPosts();
    }
}
