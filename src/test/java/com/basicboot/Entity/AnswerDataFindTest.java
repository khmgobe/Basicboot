package com.basicboot.Entity;

import com.basicboot.entity.Answer;
import com.basicboot.repository.AnswerRepository;
import com.basicboot.repository.QuestionRepository;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AnswerDataFindTest {

    @Resource
    private QuestionRepository questionRepository;

    @Resource
    private AnswerRepository answerRepository;

    @Test
    void testAnswerFind() {
        Optional<Answer> oa = answerRepository.findById(2L);
        assertTrue(oa.isPresent());
        Answer a = oa.get();
        assertEquals(2, a.getQuestion().getId());

    }

}
