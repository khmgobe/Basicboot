package com.basicboot.Entity;


import com.basicboot.entity.Question;
import com.basicboot.repository.QuestionRepository;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootTest
public class EntityFindTest {

    @Resource
    private QuestionRepository questionRepository;

    @Test
    void test() {
        List<Question> questionList = questionRepository.findAll();
        Assertions.assertEquals(2, questionList.size());

        Question question = questionList.get(0);
        Assertions.assertEquals("스프링 부트는 뭐야?", question.getSubject());
    }
}
