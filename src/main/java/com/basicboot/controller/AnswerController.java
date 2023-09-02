package com.basicboot.controller;

import com.basicboot.Service.AnswerService;
import com.basicboot.Service.QuestionService;
import com.basicboot.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/answer/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Long id, @RequestParam String content) {
        Question question = questionService.getQuestion(id);
        answerService.create(question,content);
        return String.format("redirect:/question/detail/%s", id);

    }


}
