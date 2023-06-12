package com.example.courswork2questions.service.impl;

import com.example.courswork2questions.service.QuestionService;
import com.example.courswork2questions.model.Question;
import exception.QuestionAlreadyExistsException;
import exception.QuestionNotFoundException;
import exception.QuestionsAreEmptyException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class JavaQuestionServiceImpl implements QuestionService {

    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        if (!questions.add(question)) {
            throw new QuestionAlreadyExistsException();
        }
        return question;
    }


    @Override
    public Question remove(Question question) {
        if (!questions.remove(question)) {
            throw new QuestionNotFoundException();
        }
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new QuestionsAreEmptyException();
        }
        return new ArrayList<>(questions).get(random.nextInt(questions.size()));
    }

}

