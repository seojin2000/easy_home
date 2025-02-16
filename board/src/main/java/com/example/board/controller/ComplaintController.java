package com.example.board.controller;

import com.example.board.entity.ComplaintEntity;
import com.example.board.service.ComplaintService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board/complaint")
public class ComplaintController {

    private final ComplaintService complaintService;

    // 게시글 작성
    @PostMapping("")
    public ComplaintEntity createComplaint(@RequestBody ComplaintEntity complaint) {
        return complaintService.createComplaint(complaint);
    }

    // 게시글 수정
    @PutMapping("/{id}")
    public ComplaintEntity updateComplaint(@PathVariable Integer id, @RequestBody ComplaintEntity complaint) {
        return complaintService.updateComplaint(id, complaint);
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComplaint(@PathVariable Integer id) {
        complaintService.deletecomplaint(id);
        return ResponseEntity.noContent().build();
    }

    // 개별 게시물 조회
    @GetMapping("/{id}")
    public ComplaintEntity getPost(@PathVariable Integer id) {
        return complaintService.getComplaint(id);
    }

    // 모든 게시물 조회
    @GetMapping("")
    public List<ComplaintEntity> getAllComplaints() {
        return complaintService.getAllcomplaints();
    }
}
