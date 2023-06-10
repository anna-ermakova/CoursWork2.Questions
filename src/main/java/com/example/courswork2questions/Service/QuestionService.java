package com.example.courswork2questions.Service;

import com.example.courswork2questions.model.Question;

import java.util.Collection;

public interface QuestionService {
    public Question add(String question, String answer);

    public Question add(Question question);

    public Question remove(Question question);

    Collection<Question> getAll();

    Question getRundomQuestion();
}
