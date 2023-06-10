package com.example.courswork2questions.Service.impl;

import com.example.courswork2questions.Service.ExaminerService;
import com.example.courswork2questions.Service.QuestionService;
import com.example.courswork2questions.model.Question;
import exception.IncorrectQuestionOrAnswerException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount <= 0 || amount > questionService.getAll().size()) {
            throw new IncorrectQuestionOrAnswerException();
        }
        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            result.add(questionService.getRundomQuestion());
        }
        return result;
    }
}