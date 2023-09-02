package com.basicboot.repository;

import com.basicboot.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    Question findBySubject (String subject);
    Question findBySubjectAndContent (String subject, String content);
    List<Question> findBySubjectLike(String subject);
}
