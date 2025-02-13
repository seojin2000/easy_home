package org.example.easyhomevote.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="vote")
@Data
@NoArgsConstructor
public class VoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer votePk;

    // 인증 기능 추가 시 외래키 삭제
    // private Integer managerPk;
    @ManyToOne
    @JoinColumn(name="manager_pk", nullable=false)
    private ManagerEntity manager;

    private String title;
    private String description;
    private LocalDateTime endDate;

    // 선택지
    @OneToMany(mappedBy = "vote", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VoteOption> options;

    // 선택지 추가 메소드
    public void addOption(VoteOption option) {
        options.add(option);
        option.setVote(this);
    }
}
