package me.droan.quizapp.quiz;

import me.droan.quizapp.model.QuizRepository;

/**
 * Created by drone on 16-07-2016.
 */
public class QuizPresenter implements QuizContract.UserActionListener {
    private QuizContract.View view;
    private static final String TAG = "QuizPresenter";
    QuizRepository repository = QuizRepository.getInstance();

    public QuizPresenter(QuizContract.View view) {
        this.view = view;
    }

    @Override
    public void addQuestion() {

    }

    @Override
    public void loadQuestion(int questionNumber) {
       view.showQuestion(repository.getQuestions().get(questionNumber));
    }

    @Override
    public void checkAnswer(int questionNumber) {

    }
}
