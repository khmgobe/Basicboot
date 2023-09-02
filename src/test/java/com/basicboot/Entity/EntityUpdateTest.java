package com.basicboot.Entity;

import com.basicboot.entity.Question;
import com.basicboot.repository.QuestionRepository;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EntityUpdateTest {

    @Resource
    private QuestionRepository questionRepository;

    @Test
    void testUpdate() {
        Optional<Question> oq = this.questionRepository.findById(1L);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        Question updatedQuestion = Question.builder()
                .id(q.getId())
                .subject("수정된 제목")
                .content("수정된 내용")
                .build();

        this.questionRepository.save(updatedQuestion);
    }

}
