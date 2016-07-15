package me.droan.quizapp.model;

/**
 * Created by drone on 16-07-2016.
 */
public class QuizOption {
    public QuizOption(String option, boolean isCorrect) {
        this.option = option;
        this.isCorrect = isCorrect;
    }

    private String option;

    private boolean isCorrect;


    public boolean isCorrect() {
        return isCorrect;
    }

    public String getOption() {
        return option;
    }
}
