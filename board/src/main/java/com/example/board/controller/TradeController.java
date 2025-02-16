package com.example.board.controller;

import com.example.board.entity.TradeEntity;
import com.example.board.service.TradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board/trade")
public class TradeController {

    private final TradeService tradeService;

    // 게시글 작성
    @PostMapping("")
    public TradeEntity createTrade(@RequestBody TradeEntity trade) {
        return tradeService.createTrade(trade);
    }

    // 게시글 수정
    @PutMapping("/{id}")
    public TradeEntity updateTrade(@PathVariable Integer id, @RequestBody TradeEntity trade) {
        return tradeService.updateTrade(id, trade);
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrade(@PathVariable Integer id) {
        tradeService.deleteTrade(id);
        return ResponseEntity.noContent().build();
    }

    // 개별 게시물 조회
    @GetMapping("/{id}")
    public TradeEntity getTrade(@PathVariable Integer id) {
        return tradeService.getTrade(id);
    }

    // 모든 게시물 조회
    @GetMapping("")
    public List<TradeEntity> getAllTrades() {
        return tradeService.getAllTrades();
    }
}