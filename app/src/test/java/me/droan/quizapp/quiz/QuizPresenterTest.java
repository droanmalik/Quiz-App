package me.droan.quizapp.quiz;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;

/**
 * Created by drone on 16-07-2016.
 */
public class QuizPresenterTest {


    @Mock
    QuizPresenter presenter;

    @Mock
    QuizContract.View view;

    @Before
    public void setUp() throws Exception {
        presenter = new QuizPresenter(view);
    }

    @Test
    public void clickNext_showNewQuestion() {
        presenter.loadQuestion(0);
        verify(view).showQuestion();
    }


    @Test
    public void chickNext_checkAnswer() {
        presenter.loadQuestion(1);
        verify(presenter).checkAnswer(0);
    }
}