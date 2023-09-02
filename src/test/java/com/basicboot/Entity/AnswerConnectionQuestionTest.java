package com.basicboot.Entity;

import com.basicboot.entity.Answer;
import com.basicboot.entity.Question;
import com.basicboot.repository.QuestionRepository;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AnswerConnectionQuestionTest{

    @Resource
    private QuestionRepository questionRepository;

    @Test
    @Transactional
    void testQuestion() {
        Optional<Question> oq = this.questionRepository.findById(2L);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        List<Answer> answerList = q.getAnswerList();

        assertEquals(2, answerList.size());
        assertEquals("자동 생성", answerList.get(0).getContent());
    }

}
