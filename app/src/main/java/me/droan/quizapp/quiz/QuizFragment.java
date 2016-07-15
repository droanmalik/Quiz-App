package me.droan.quizapp.quiz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.droan.quizapp.R;
import me.droan.quizapp.model.CheckboxQuiz;
import me.droan.quizapp.model.FreeFlowQuiz;
import me.droan.quizapp.model.QuizBase;
import me.droan.quizapp.model.QuizOption;
import me.droan.quizapp.model.RadioQuiz;

/**
 * Created by drone on 16-07-2016.
 */
public class QuizFragment extends Fragment implements QuizContract.View, View.OnClickListener {

    @Bind(R.id.txt_question)
    TextView txtQuestion;
    @Bind(R.id.frm_lay_question)
    LinearLayout questionlayout;
    @Bind(R.id.btn_next)
    Button btnNext;

    private int questionNumber = 0;

    private QuizContract.UserActionListener presenter;

    public static QuizFragment newInstance() {

        Bundle args = new Bundle();

        QuizFragment fragment = new QuizFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setRetainInstance(true);
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        btnNext.setOnClickListener(this);
        presenter = new QuizPresenter(this);
        presenter.loadQuestion(questionNumber);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    boolean isAnswerCorrect = false;

    @Override
    public void showQuestion(QuizBase question) {
        isAnswerCorrect=false;
        questionlayout.removeAllViews();
        if (question instanceof RadioQuiz) {
            final RadioQuiz quiz = (RadioQuiz) question;
            txtQuestion.setText(quiz.getQuestion());
            RadioGroup radioGroup = new RadioGroup(getActivity());
            final List<QuizOption> options = quiz.getOptions();
            for (QuizOption i : options) {
                RadioButton radioButton = new RadioButton(getActivity());
                radioButton.setText(i.getOption());
                radioGroup.addView(radioButton);
            }
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {

                }
            });
            questionlayout.addView(radioGroup);

        } else if (question instanceof CheckboxQuiz) {
            CheckboxQuiz quiz = (CheckboxQuiz) question;
            txtQuestion.setText(quiz.getQuestion());
            List<QuizOption> options = quiz.getOptions();
            for (QuizOption i : options) {
                CheckBox checkBox = new CheckBox(getActivity());
                checkBox.setText(i.getOption());
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                    }
                });
                questionlayout.addView(checkBox);
            }

        } else if (question instanceof FreeFlowQuiz) {
            FreeFlowQuiz quiz = (FreeFlowQuiz) question;
            EditText editText = new EditText(getActivity());
            txtQuestion.setText(quiz.getQuestion());
            questionlayout.addView(editText);
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
    }

    @Override
    public void showAnswerToast(boolean isCorrect) {

    }

    @Override
    public void onClick(View view) {
        if (view == btnNext) {
            presenter.loadQuestion(++questionNumber);
        }
    }
}
