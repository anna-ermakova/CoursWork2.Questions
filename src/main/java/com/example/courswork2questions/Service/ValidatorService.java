package com.example.courswork2questions.Service;

import com.example.courswork2questions.model.Question;
import exception.ArgumentQuestionRepeatsAnswerException;
import exception.IncorrectQuestionOrAnswerException;
import org.springframework.stereotype.Service;

@Service
public class ValidatorService {
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