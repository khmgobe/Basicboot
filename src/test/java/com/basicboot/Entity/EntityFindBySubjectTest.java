package com.basicboot.Entity;


import com.basicboot.entity.Question;
import com.basicboot.repository.QuestionRepository;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EntityFindBySubjectTest {

    @Resource
    private QuestionRepository questionRepository;

    @Test
    void test() {
        Question q = questionRepository.findBySubject("스프링 부트는 뭐야?");
        Assertions.assertEquals(2L, q.getId());

    }
}
