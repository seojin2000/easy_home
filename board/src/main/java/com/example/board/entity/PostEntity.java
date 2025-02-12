package com.example.board.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;


@EntityListeners(AuditingEntityListener.class)
@Data
@Entity
public class PostEntity extends BaseTimeEntity {

    @Column(length = 40, nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private String author;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CommentEntity> comments;

//    @ManyToOne
//    @JoinColumn(name = "board_id")
//    private Board board;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private Member member;

}
