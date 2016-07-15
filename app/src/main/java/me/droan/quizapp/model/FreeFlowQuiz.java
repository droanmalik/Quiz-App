package me.droan.quizapp.model;

/**
 * Created by drone on 16-07-2016.
 */
public class FreeFlowQuiz extends QuizBase {
    private String answer;

    public FreeFlowQuiz(String question, String answer) {

        this.question = question;
        this.answer = answer;
    }


    public String getAnswer() {
        return answer;
    }
}
