package com.example.board.service;

import com.example.board.entity.FreeEntity;
import com.example.board.entity.NoticeEntity;
import com.example.board.repository.FreeRepository;
import com.example.board.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;

    // 게시글 작성
    public NoticeEntity createPost(NoticeEntity post) {
        post.setCreatedDate(LocalDateTime.now());
        return noticeRepository.save(post);
    }

    // 게시글 수정
    public NoticeEntity updatePost(Integer id, NoticeEntity postDetails) {
        NoticeEntity post = noticeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        post.setTitle(postDetails.getTitle());
        post.setContent(postDetails.getContent());
        post.setAuthor(postDetails.getAuthor());
        post.setModifiedDate(LocalDateTime.now());
        return noticeRepository.save(post);
    }

    // 게시글 삭제
    public void deletePost(Integer id) {
        noticeRepository.deleteById(id);
    }

    // 개별 게시물 조회
    public NoticeEntity getPost(Integer id) {
        return noticeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
    }

    // 모든 게시물 조회
    public List<NoticeEntity> getAllPosts() {
        return noticeRepository.findAll();
    }

}
