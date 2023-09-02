package com.basicboot.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Answer{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private long id;

    @Column(columnDefinition = "TEXT", name = "answer_content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    @CreatedDate
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime modifiedDate;
    @Builder
    Answer(String content, Question question, LocalDateTime createDate, LocalDateTime modifiedDate){
        this.content = content;
        this.question = question;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }
}
