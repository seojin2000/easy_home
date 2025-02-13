package org.example.easyhomevote.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="userentity") // user라고 하면 h2에 인식이 안돼서 userentity로 설정
@Data
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userPk;

    private String email;
}
