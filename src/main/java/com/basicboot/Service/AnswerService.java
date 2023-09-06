package com.basicboot.Service;

import com.basicboot.entity.Answer;
import com.basicboot.entity.Question;
import com.basicboot.entity.Users;
import com.basicboot.repository.AnswerRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@RequiredArgsConstructor
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    public void create(Question question, String content, Users author) {
        Answer answer = Answer.builder()
                .content(content)
                .createDate(LocalDateTime.now())
                .question(question)
                .author(author)
                .build();
        answerRepository.save(answer);

    }
}
