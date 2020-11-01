package com.example.quizlet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This is the main class that gets JSON data from the restful website and passes that to different activities
 *
 * @author Hareem Khanazmi 16946714
 * @author Jack Wang 19062259
 */
public class MainActivity extends AppCompatActivity {
    //Define Variables
    ArrayList<Questions> ques = new ArrayList<>();
    private RequestQueue requestQueue;
    Questions q;
    TextView view, scoreview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue = Volley.newRequestQueue(this);
        getJSONData();

        Button playbutton = findViewById(R.id.playbutton);

        view = findViewById(R.id.titleView);
        scoreview = findViewById(R.id.ScoreView);

        if (Scores.name == null) {
            Scores.name = "";
        }

        Score s = new Score(quiz.points, Scores.name);
        scoreview.setText("" + s.toString());


        playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent(MainActivity.this, quiz.class);
                in.putExtra("question", q);

                startActivity(in);


            }
        });


    }

    /**
     * This is the method that gets the json data from the restful website
     */
    public void getJSONData() {

        String url = "http://10.0.2.2:8080/QuizManager/quizservice/quesControl/";
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray ob = new JSONArray(response);

                            for (int i = 0; i < ob.length(); i++) {
                                JSONObject desc = ob.getJSONObject(i);
                                String id = desc.getString("id");
                                String questions = desc.getString("questions");
                                String answer = desc.getString("answers");
                                String option1 = desc.getString("option1");
                                String option2 = desc.getString("option2");
                                String option3 = desc.getString("option3");
                                String option4 = desc.getString("option4");
                                q = new Questions(id, questions, answer, option1, option2, option3, option4);

                                ques.add(q);

                                q.setQuestSet(ques);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);
    }

    ;


}
