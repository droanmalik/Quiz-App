package me.droan.quizapp.model;

import java.util.List;

/**
 * Created by drone on 16-07-2016.
 */
public abstract class QuizBase {
    public String question;
    public List<QuizOption> options;


    public String getQuestion(){
        return question;
    }


    public List<QuizOption> getOptions() {
        return options;
    }
}
