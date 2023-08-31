package com.basicboot.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Answer extends TimeBaseEntity{


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private long id;

    @Column(columnDefinition = "TEXT", name = "answer_content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    @Builder
    Answer(String content){
        this.content = content;
    }
}
