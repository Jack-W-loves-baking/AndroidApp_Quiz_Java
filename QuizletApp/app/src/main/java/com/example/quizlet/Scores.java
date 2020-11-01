package com.example.quizlet;


import android.content.Intent;
import android.os.Bundle;

import android.util.DisplayMetrics;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;


import androidx.annotation.Nullable;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.quizlet.quiz.points;

/**
 * This class is used to ask for username and shows the points for that user
 *
 * @author Hareem Khanazmi 16946714
 * @author Jack Wang 19062259
 */
public class Scores extends AppCompatActivity {
    //Define Varaibles
    public static String name;
    TextView score;
    EditText user;
    Button submit;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userscore);

        DisplayMetrics disp = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(disp);

        int width = disp.widthPixels;
        int height = disp.heightPixels;

        getWindow().setLayout((int) (width * 0.8), (int) (height * 0.7));

        user = findViewById(R.id.user);
        score = findViewById(R.id.Score);
        submit = findViewById(R.id.Submitbutton);

        score.setText("" + points);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = user.getText().toString();

                Intent in = new Intent(Scores.this, MainActivity.class);


                startActivity(in);

            }
        });


    }
}









