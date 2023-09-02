package com.basicboot.Entity;

import com.basicboot.entity.Question;
import com.basicboot.repository.QuestionRepository;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EntitySubjectLikeTest {

    @Resource
    private QuestionRepository questionRepository;

    @Test
    void testLike() {
        List<Question> qList = questionRepository.findBySubjectLike("스프링%");
        Question q = qList.get(0);
        assertEquals("스프링 부트는 뭐야?", q.getSubject());
    }
}
