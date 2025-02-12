package com.example.board.controller;

import com.example.board.dto.CommentDto;
import com.example.board.entity.CommentEntity;
import com.example.board.entity.PostEntity;
import com.example.board.service.CommentService;
import com.example.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;
    private final PostService postService;

    // 댓글 작성
    @PostMapping("post/{postId}")
    public CommentEntity createComment(@PathVariable Integer postId, @RequestBody CommentDto commentDto) {
        // 여기에서 PostEntity를 조회하는 로직이 필요함
        PostEntity post = postService.getPost(postId);
        return commentService.createComment(post, commentDto.getAuthor(), commentDto.getContent());
    }

    // 댓글 수정
    @PutMapping("/{id}")
    public CommentEntity updateComment(@PathVariable Integer id, @RequestBody CommentDto commentDto) {
        return commentService.updateComment(id, commentDto.getAuthor(), commentDto.getContent());
    }

    // 댓글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Integer id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }

    // 개별 댓글 조회
    @GetMapping("/{id}")
    public CommentEntity getComment(@PathVariable Integer id) {
        return commentService.getComment(id);
    }

    // 모든 댓글 조회
    @GetMapping("")
    public List<CommentEntity> getAllComments() {
        return commentService.getAllComments();
    }
}
