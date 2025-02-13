package org.example.easyhomevote.controller;

import org.example.easyhomevote.dto.*;
import org.example.easyhomevote.entity.VoteOption;
import org.example.easyhomevote.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vote")
public class VoteController {
    @Autowired
    private VoteService voteService;

    // 투표 등록 - 관리자
    @PostMapping("")
    public ResponseEntity<String> createVote(@RequestBody VoteDto voteDto) {
        voteService.createVote(voteDto);
        return ResponseEntity.ok("투표 생성 완료");
    }

    // 투표 참여 - 입주민
    @PostMapping("/join")
    public ResponseEntity<String> joinVote(@RequestBody AnswerDto answerDto) {
        voteService.joinVote(answerDto);
        return ResponseEntity.ok("투표 참여 완료");
    }

    // 투표 결과 조회 - 관리자, 입주민
    @GetMapping("/{votePk}")
    public VoteResultDto getVoteResults(@PathVariable Integer votePk) {
        return voteService.getVoteResults(votePk);
    }

    // 투표 수정
    @PutMapping("/{votePk}")
    public ResponseEntity<VoteUpdateResDto> updateVote(
            @PathVariable Integer votePk,
            @RequestBody VoteUpdateReqDto requestDto) {
        VoteUpdateResDto updatedVote = voteService.updateVote(votePk, requestDto);
        return ResponseEntity.ok(updatedVote);
    }

    // 투표 삭제
    @DeleteMapping("/{votePk}")
    public ResponseEntity<String> deleteVote(@PathVariable Integer votePk) {
        voteService.deleteVote(votePk);
        return ResponseEntity.ok("투표 삭제 완료");
    }

    // 선택지 추가
    @PostMapping("/{votePk}/option")
    public ResponseEntity<String> addOption(@PathVariable Integer votePk,
                                              @RequestBody OptionDto optionDto) {
        voteService.addOption(votePk, optionDto);
        return ResponseEntity.ok("선택지 추가 완료");
    }

    // 선택지 수정
    @PutMapping("/{votePk}/option/{optionPk}")
    public ResponseEntity<OptionUpdateResDto> updateOption(@PathVariable Integer votePk,
                                                               @PathVariable Integer optionPk,
                                                               @RequestBody OptionDto optionDto) {
        OptionUpdateResDto updatedOptionDto = voteService.updateOption(votePk, optionPk, optionDto);
        return ResponseEntity.ok(updatedOptionDto);
    }

    // 선택지 삭제
    @DeleteMapping("/{votePk}/option/{optionPk}")
    public ResponseEntity<String> deleteOption(@PathVariable Integer votePk,
                                                 @PathVariable Integer optionPk) {
        voteService.deleteOption(votePk, optionPk);
        return ResponseEntity.ok("선택지 삭제 완료");
    }
}
