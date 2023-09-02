package com.basicboot.Entity;

import com.basicboot.entity.Question;
import com.basicboot.repository.QuestionRepository;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EntityDeleteTest {

    @Resource
    private QuestionRepository questionRepository;

    @Test
    void testDelete() {
        assertEquals(2, questionRepository.count());
        Optional<Question> oq = questionRepository.findById(1L);
        assertTrue(oq.isPresent());
        Question q = oq.get();
        questionRepository.delete(q);
        assertEquals(1, questionRepository.count());
    }
}
