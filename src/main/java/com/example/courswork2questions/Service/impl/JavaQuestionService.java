package com.example.courswork2questions.Service.impl;

import com.example.courswork2questions.Service.QuestionService;
import com.example.courswork2questions.model.Question;
import exception.ArgumentQuestionRepeatsAnswerException;
import exception.IncorrectQuestionOrAnswerException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    public JavaQuestionService() {
    }

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        checkQuestion(question.getQuestion(), question.getAnswer());
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        checkQuestion(question.getQuestion(), question.getAnswer());
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRundomQuestion() {
        int value = random.гоооnextInt(questions.size());
        List<Question> questionList = new ArrayList<>(getAll());
        return questionList.get(value);
    }

    public Question checkQuestion(String question, String answer) {
        if (question == null || answer == null) {
            throw new IncorrectQuestionOrAnswerException();
        }
        if (question.equals(answer)) {
            throw new ArgumentQuestionRepeatsAnswerException();
        }
        return new Question(question, answer);
    }

}

