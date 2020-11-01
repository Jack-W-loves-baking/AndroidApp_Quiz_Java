package com.example.quizlet;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

/**
 * This is the Quiz class that checks if the selected answers is correct or wrong
 * and calculates their scores.
 *
 * @author Hareem Khanazmi 16946714
 * @author Jack Wang 19062259
 */
public class quiz extends AppCompatActivity {
    //Define Variables
    ActionBar actionBar;
    public TextView Quiz;
    public Button A, B, C, D, next;
    int count = 0;
    int pressedAnsA = 0, pressedAnsB = 0, pressedAnsC = 0, pressedAnsD = 0, pressed = 0;
    public static int points = 0;
    Questions q = new Questions();
    Questions ques;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        Intent in = getIntent();
        ques = (Questions) in.getSerializableExtra("question");


        A = findViewById(R.id.buttonA);
        B = findViewById(R.id.buttonB);
        C = findViewById(R.id.buttonC);
        D = findViewById(R.id.buttonD);
        next = findViewById(R.id.Nextbutton);
        Quiz = findViewById(R.id.quizView);

        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pressedAnsA = 1;
                check();

            }
        });
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pressedAnsB = 1;
                check();


            }
        });
        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pressedAnsC = 1;
                check();


            }
        });
        D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pressedAnsD = 1;
                check();

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == ques.getQuestSet().size() - 1) {
                    Intent in = new Intent(quiz.this, Scores.class);
                    startActivity(in);
                }
                A.setBackgroundResource(R.drawable.customize_button);
                B.setBackgroundResource(R.drawable.customize_button);
                C.setBackgroundResource(R.drawable.customize_button);
                D.setBackgroundResource(R.drawable.customize_button);

                count++;
                if (count != ques.getQuestSet().size()) {
                    NextQuestion(count);
                }


            }
        });
        if (count == 0) {
            NextQuestion(count);
        }


        if (pressed == 1) {
            A.setEnabled(false);
            B.setEnabled(false);
            C.setEnabled(false);
            D.setEnabled(false);
        } else {
            A.setEnabled(true);
            B.setEnabled(true);
            C.setEnabled(true);
            D.setEnabled(true);
        }


    }

    /**
     * This method is used to check whether the selected option is correct or not
     */
    private void check() {
        if (pressedAnsA == 1) {

            if (A.getText().equals(ques.getQuestSet().get(count).getAnswer())) {
                A.setBackgroundColor(Color.GREEN);
                pressedAnsA = 0;
                pressed = 0;
                points += 10;


            } else {
                A.setBackgroundColor(Color.RED);
                pressedAnsA = 0;
                pressed = 0;
                CorrectAnswerCheck();


            }
        } else if (pressedAnsB == 1) {

            if (B.getText().equals(ques.getQuestSet().get(count).getAnswer())) {
                B.setBackgroundColor(Color.GREEN);
                pressedAnsB = 0;
                pressed = 0;
                points += 10;


            } else {
                B.setBackgroundColor(Color.RED);
                pressedAnsB = 0;
                pressed = 0;
                CorrectAnswerCheck();


            }
        } else if (pressedAnsC == 1) {
            if (C.getText().equals(ques.getQuestSet().get(count).getAnswer())) {
                C.setBackgroundColor(Color.GREEN);
                pressedAnsC = 0;
                pressed = 0;
                points += 10;


            } else {
                C.setBackgroundColor(Color.RED);
                pressedAnsC = 0;
                pressed = 0;
                CorrectAnswerCheck();

            }
        } else if (pressedAnsD == 1) {
            if (D.getText().equals(ques.getQuestSet().get(count).getAnswer())) {
                D.setBackgroundColor(Color.GREEN);
                pressedAnsD = 0;
                pressed = 0;
                points += 10;


            } else {
                D.setBackgroundColor(Color.RED);
                pressedAnsD = 0;
                pressed = 0;
                CorrectAnswerCheck();

            }
        }


    }

    /**
     * This method changes the buttons colour after checking
     */
    private void CorrectAnswerCheck() {

        if (A.getText().equals(ques.getQuestSet().get(count).getAnswer())) {
            A.setBackgroundColor(Color.GREEN);
        } else if (B.getText().equals(ques.getQuestSet().get(count).getAnswer())) {
            B.setBackgroundColor(Color.GREEN);
        } else if (C.getText().equals(ques.getQuestSet().get(count).getAnswer())) {
            C.setBackgroundColor(Color.GREEN);
        } else if (D.getText().equals(ques.getQuestSet().get(count).getAnswer())) {
            D.setBackgroundColor(Color.GREEN);
        }

    }

    /**
     * This method displays questions for every c number
     *
     * @param c
     */
    private void NextQuestion(int c) {
        Quiz.setText(ques.getQuestSet().get(c).getQuestion());
        A.setText(ques.getQuestSet().get(c).getOption1());
        B.setText(ques.getQuestSet().get(c).getOption2());
        C.setText(ques.getQuestSet().get(c).getOption3());
        D.setText(ques.getQuestSet().get(c).getOption4());
    }


}
