package org.example.easyhomevote.controller;

import org.example.easyhomevote.dto.*;
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

    // 투표 결과 조회
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

/*    // 선택지 추가
    @PostMapping("/{surveyPk}/question")
    public ResponseEntity<String> addQuestion(@PathVariable Integer surveyPk,
                                              @RequestBody QuestionDto questionDto) {
        SurveyQuestion newQuestion = voteService.addQuestion(surveyPk, questionDto);
        return ResponseEntity.ok("선택지 추가 완료");
    }

    // 선택지 수정
    @PutMapping("/{surveyPk}/question/{questionPk}")
    public ResponseEntity<QuestionUpdateResDto> updateQuestion(@PathVariable Integer surveyPk,
                                                               @PathVariable Integer questionPk,
                                                               @RequestBody QuestionDto questionDto) {
        QuestionUpdateResDto updatedQuestionDto = voteService.updateQuestion(surveyPk, questionPk, questionDto);
        return ResponseEntity.ok(updatedQuestionDto);
    }

    // 선택지 삭제
    @DeleteMapping("/{surveyPk}/question/{questionPk}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Integer surveyPk,
                                                 @PathVariable Integer questionPk) {
        voteService.deleteQuestion(surveyPk, questionPk);
        return ResponseEntity.ok("선택지 삭제 완료");
    }*/
}
