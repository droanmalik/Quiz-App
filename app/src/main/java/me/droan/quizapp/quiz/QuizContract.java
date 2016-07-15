package me.droan.quizapp.quiz;

import me.droan.quizapp.model.QuizBase;

/**
 * Created by drone on 16-07-2016.
 */
public interface QuizContract {

    public interface View {
        void showQuestion(QuizBase question);

        void showAnswerToast(boolean isCorrect);
    }

    public interface UserActionListener {
        void addQuestion();

        void loadQuestion(int questionNumber);

        void checkAnswer(int qauestionNumner);
    }
}
