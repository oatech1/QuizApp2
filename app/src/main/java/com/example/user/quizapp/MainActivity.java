package com.example.user.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView wel, startQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wel = findViewById(R.id.welc);
        startQ = findViewById(R.id.textView2);
      //  priceMsg + "\nThank you";
        String welMsg = "This is a multiple Quiz."+"\nThere are 5 questions."+"\nYou have 1 minutes."+"\nBest of luck.";
        wel.setText(welMsg);
        startQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),QuizActivity.class);
                startActivity(i);
            }
        });
    }
}
