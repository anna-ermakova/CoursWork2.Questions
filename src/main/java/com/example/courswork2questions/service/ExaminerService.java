package com.example.courswork2questions.service;

import com.example.courswork2questions.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);

}

