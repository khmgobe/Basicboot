package com.basicboot.Entity;

import com.basicboot.entity.Answer;
import com.basicboot.entity.Question;
import com.basicboot.repository.AnswerRepository;
import com.basicboot.repository.QuestionRepository;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AnswerDataCreateTest {

    @Resource
    private QuestionRepository questionRepository;

    @Resource
    private AnswerRepository answerRepository;

    @Test
    void testAnswer() {
        Optional<Question> oq = questionRepository.findById(2L);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        Answer a = new Answer();
        Answer CreateAnswer = Answer.builder()
                .content("자동 생성")
                .question(q)
                .createDate(LocalDateTime.now())
                .build();
        this.answerRepository.save(CreateAnswer);
    }
}
