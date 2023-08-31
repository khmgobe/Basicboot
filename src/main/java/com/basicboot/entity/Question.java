package com.basicboot.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Question extends TimeBaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 200, nullable = false)
    private String subject;

    @Column(columnDefinition = "TEXT" , nullable = false)
    private String content;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList = new ArrayList<>();

    @Builder
    Question(long id, String subject, String content){
        this.id = id;
        this.subject = subject;
        this.content = content;
    }
}
