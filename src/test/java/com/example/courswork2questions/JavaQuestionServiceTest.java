package com.example.courswork2questions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.HashSet;

import com.example.courswork2questions.Service.QuestionService;
import com.example.courswork2questions.Service.impl.JavaQuestionService;
import com.example.courswork2questions.model.Question;
import exception.IncorrectQuestionOrAnswerException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JavaQuestionServiceTest {

    private final QuestionService questionService = new JavaQuestionService();

    @BeforeEach
    public void beforeEach() {
        questionService.add(new Question("Q1", "A1"));
        questionService.add(new Question("Q2", "A2"));
        questionService.add(new Question("Q3", "A3"));
    }

    @AfterEach
    public void afterEach() {
        new HashSet<>(questionService.getAll()).forEach(questionService::remove);
    }

    @Test
    public void add1Test() {
        int beforeCount = questionService.getAll().size();
        Question question = new Question("Q4", "A4");

        assertThat(questionService.add(question))
                .isEqualTo(question)
                .isIn(questionService.getAll());
        assertThat(questionService.getAll()).hasSize(beforeCount + 1);
    }

    @Test
    public void add2Test() {
        int beforeCount = questionService.getAll().size();
        Question question = new Question("Q4", "A4");

        assertThat(questionService.add("Q4", "A4"))
                .isEqualTo(question)
                .isIn(questionService.getAll());
        assertThat(questionService.getAll()).hasSize(beforeCount + 1);
    }

    @Test
    public void add1NegativeTest() {
        Question question = new Question("Q1", "A1");

        assertThatExceptionOfType(IncorrectQuestionOrAnswerException.class)
                .isThrownBy(() -> questionService.add(question));
    }

    @Test
    public void add2NegativeTest() {
        assertThatExceptionOfType(IncorrectQuestionOrAnswerException.class)
                .isThrownBy(() -> questionService.add("Q1", "A1"));
    }

    @Test
    public void removeTest() {
        int beforeCount = questionService.getAll().size();
        Question question = new Question("Q2", "A2");

        assertThat(questionService.remove(question))
                .isEqualTo(question)
                .isNotIn(questionService.getAll());
        assertThat(questionService.getAll()).hasSize(beforeCount - 1);
    }

    @Test
    public void removeNegativeTest() {
        assertThatExceptionOfType(IncorrectQuestionOrAnswerException.class)
                .isThrownBy(() -> questionService.remove(new Question("Q4", "A4")));
    }

    @Test
    public void getAllTest() {
        assertThat(questionService.getAll())
                .hasSize(3)
                .containsExactlyInAnyOrder(
                        new Question("Q1", "A1"),
                        new Question("Q3", "A3"),
                        new Question("Q2", "A2")
                );
    }

    @Test
    public void getRandomQuestionTest() {
        assertThat(questionService.getRundomQuestion())
                .isNotNull()
                .isIn(questionService.getAll());
    }

    @Test
    public void getRandomQuestionNegativeTest() {
        afterEach();

        assertThatExceptionOfType(IncorrectQuestionOrAnswerException.class)
                .isThrownBy(questionService::getRundomQuestion);
    }

}