package me.droan.quizapp.model;

import java.util.List;

/**
 * Created by drone on 16-07-2016.
 */
public class RadioQuiz extends QuizBase {
    public RadioQuiz(String question, List<QuizOption> options) {
        this.question = question;
        this.options = options;
    }
}
