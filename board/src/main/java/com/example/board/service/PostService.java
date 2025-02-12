package com.example.board.service;

import com.example.board.entity.PostEntity;
import com.example.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    // 게시글 작성
    public PostEntity createPost(PostEntity post) {
        post.setCreatedDate(LocalDateTime.now());
        return postRepository.save(post);
    }

    // 게시글 수정
    public PostEntity updatePost(Integer id, PostEntity postDetails) {
        PostEntity post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        post.setTitle(postDetails.getTitle());
        post.setContent(postDetails.getContent());
        post.setAuthor(postDetails.getAuthor());
        post.setModifiedDate(LocalDateTime.now());
        return postRepository.save(post);
    }

    // 게시글 삭제
    public void deletePost(Integer id) {
        postRepository.deleteById(id);
    }

    // 개별 게시물 조회
    public PostEntity getPost(Integer id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
    }

    // 모든 게시물 조회
    public List<PostEntity> getAllPosts() {
        return postRepository.findAll();
    }

}
