package com.example.courswork2questions.Service;

import com.example.courswork2questions.model.Question;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;

@Service
@AllArgsConstructor
public class JavaQuestionService implements QuestionService {

    private final Random random = new Random();

    private final ValidatorService validatorService;

    @Override
    public Question add(String question, String answer) {
        Question questionAdd = new Question(question, answer);
        return add(questionAdd);
    }

    @Override
    public String add(Question question) {
        return null;
    }

    @Override
    public String remove(Question question) {
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return null;
    }

    @Override
    public Question getRundomQuestion() {

        }
    }
}
