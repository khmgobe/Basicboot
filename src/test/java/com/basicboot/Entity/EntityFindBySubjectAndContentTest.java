package com.basicboot.Entity;

import com.basicboot.entity.Question;
import com.basicboot.repository.QuestionRepository;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EntityFindBySubjectAndContentTest {

    @Resource
    private QuestionRepository questionRepository;

    @Test
    void test() {
        Question question = questionRepository.findBySubjectAndContent("스프링 부트는 뭐야?","스프링 부트! 친해지자 !");
        Assertions.assertEquals(2L, question.getId());
    }
}
