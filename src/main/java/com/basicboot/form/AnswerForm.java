package com.basicboot.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;

@Getter
public class AnswerForm {

    @NotEmpty(message = "내용은 필수항목입니다.")
    private String content;

    @Builder
    public AnswerForm(String content) {
        this.content = content;
    }
}
