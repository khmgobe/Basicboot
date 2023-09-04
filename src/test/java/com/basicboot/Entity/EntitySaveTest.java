package com.basicboot.Entity;


import com.basicboot.entity.Question;
import com.basicboot.repository.QuestionRepository;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;

@EnableJpaAuditing
@SpringBootTest
public class EntitySaveTest {
    @Resource
    private QuestionRepository questionRepository;

    @Test
    void test() {
        Question question = Question.builder()
                .subject("스프링 부트는 뭐야?")
                .content("스프링 부트! 친해지자 ! ")
                .createDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();
        questionRepository.save(question);

        Question question2 = Question.builder()
                .subject("스프링 부트 반가워")
                .content("스프링 부트 행복해")
                .createDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();

        questionRepository.save(question2);
    }
}
