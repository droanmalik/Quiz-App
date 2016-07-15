package me.droan.quizapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by drone on 16-07-2016.
 */
public class QuizRepository {
    private static QuizRepository repository;
    private List<QuizBase> questions = new ArrayList<>();

    public List<QuizBase> getQuestions() {
        return questions;
    }

    private QuizRepository() {
        List<QuizOption> quizOption = new ArrayList<>();
        quizOption.add(new QuizOption("11", true));
        quizOption.add(new QuizOption("12", false));
        quizOption.add(new QuizOption("10", false));
        quizOption.add(new QuizOption("None of these", false));
        RadioQuiz quiz1 = new RadioQuiz("What is 5+6", quizOption);

        List<QuizOption> quizOption2 = new ArrayList<>();
        quizOption2.add(new QuizOption("1", false));
        quizOption2.add(new QuizOption("9", false));
        quizOption2.add(new QuizOption("2", true));
        quizOption2.add(new QuizOption("3", true));
        CheckboxQuiz quiz2 = new CheckboxQuiz("Select all prime numbers", quizOption2);

        List<QuizOption> quizOption3 = new ArrayList<>();
        quizOption3.add(new QuizOption("2050", false));
        quizOption3.add(new QuizOption("1600", false));
        quizOption3.add(new QuizOption("1790", false));
        quizOption3.add(new QuizOption("None of these", true));
        RadioQuiz quiz3 = new RadioQuiz("When was Obama born", quizOption3);

        FreeFlowQuiz quiz4 = new FreeFlowQuiz("What is 99 X 10", "990");

        questions.add(quiz1);
        questions.add(quiz2);
        questions.add(quiz3);
        questions.add(quiz4);
    }

    public static QuizRepository getInstance() {

        if (repository == null) {
            repository = new QuizRepository();
        }
        return repository;
    }

}
