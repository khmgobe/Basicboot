package com.basicboot.Entity;


import com.basicboot.entity.Question;
import com.basicboot.repository.QuestionRepository;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

@SpringBootTest
public class EntityFindIdTest {

    @Resource
    private QuestionRepository questionRepository;

    @Test
    void test() {
        Optional<Question> oq = questionRepository.findById(2L);
        if(oq.isPresent()) {
            Question q = oq.get();
            Assertions.assertEquals("스프링 부트는 뭐야?", q.getSubject());
        }

    }
}
