package com.example.board.service;

import com.example.board.entity.CommentEntity;
import com.example.board.entity.PostEntity;
import com.example.board.repository.CommentRepository;
import com.example.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    // 댓글 작성
    public CommentEntity createComment(PostEntity post, String author, String content) {
        CommentEntity comment = new CommentEntity();
        comment.setContent(content);
        comment.setAuthor(author);
        comment.setCreatedDate(LocalDateTime.now());
        comment.setPost(post);
        return commentRepository.save(comment);
    }

    // 댓글 수정
    public CommentEntity updateComment(Integer id, String author, String content) {
        CommentEntity comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        comment.setAuthor(author);
        comment.setContent(content);
        comment.setModifiedDate(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    // 댓글 삭제
    public void deleteComment(Integer id) {
        commentRepository.deleteById(id);
    }

    // 개별 댓글 조회
    public CommentEntity getComment(Integer id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
    }

    // 모든 댓글 조회
    public List<CommentEntity> getAllComments() {
        return commentRepository.findAll();
    }
}