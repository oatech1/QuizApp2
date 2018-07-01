package com.example.user.quizapp;

import android.app.Dialog;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private TextView tQues, nQues;
    Button nxtQues;
    RadioGroup rgp;
    private Chronometer chronometer;
    private boolean running;
    RadioButton rb1, rb2, rb3, rb4;
    String questions[] = {"\t\n" +
            "Federation Cup, World Cup, Allywyn International Trophy and Challenge Cup are awarded to winners of", "\t\n" +
            "Eritrea, which became the 182nd member of the UN in 1993, is in the continent of", "Escape velocity of a rocket fired from the earth towards the moon is a velocity to get rid of the", "\t\n" +
            "For safety, the fuse wire used in the mains for household supply of electricity must be made of metal having", "\t\n" +
            "For which of the following disciplines is Nobel Prize awarded?"};
    String ans[] ={"Volleyball","Africa","Earth's gravitational pull","low melting point", "All of the above"};
    String options[] = {"Basketball","Volleyball","Cricket","Tennis","Asia.","Africa.","Australia.","Europe","\tMoon's gravitational pull","Centripetal force due to the earth's rotation","Pressure of the atmosphere","\t\n" +
         "None of the Above",   "low specific heat","high resistance","high melting point","low melting point","All of the above","Physics and Chemistry","Physiology or Medicine","Literature, Peace and Economics"};
    int flag = 0;
    int flag2 = 1;
    public  int mark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        tQues = findViewById(R.id.textView2);
        nQues = findViewById(R.id.textView);
        nxtQues = findViewById(R.id.button);
        rgp = findViewById(R.id.radioGroup);
        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton1);
        rb3 = findViewById(R.id.radioButton2);
        rb4 = findViewById(R.id.radioButton3);
        chronometer = findViewById(R.id.chron);
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if ((SystemClock.elapsedRealtime() - chronometer.getBase())>=(60*1000)){
                    //chronometer.setBase(SystemClock.elapsedRealtime());
                    Toast.makeText(getApplicationContext(),"Time Up", Toast.LENGTH_SHORT).show();
                    running =false;
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                }
            }
        });
        tQues.setText(questions[flag]);
        nQues.setText("QUESTION "+ flag2);
        rb1.setText(options[0]);
        rb2.setText(options[1]);
        rb3.setText(options[2]);
        rb4.setText(options[3]);
        starChron(chronometer);

        nxtQues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton selectedOpt = findViewById(rgp.getCheckedRadioButtonId());
                String ansText = selectedOpt.getText().toString();
                if(ansText.equalsIgnoreCase(ans[flag])){
                    mark+=1;
                   // Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();
                }else{

                    mark+=0;
                   // Toast.makeText(getApplicationContext(),"Wrong",Toast.LENGTH_SHORT).show();
                }
                flag++;
                flag2++;
                if(flag < questions.length){
                    tQues.setText(questions[flag]);
                    nQues.setText("QUESTION "+flag2);
                    rb1.setText(options[flag*4]);
                    rb2.setText(options[(flag*4)+1]);
                    rb3.setText(options[(flag*4)+2]);
                    rb4.setText(options[(flag*4)+3]);


                }else{


                    Toast.makeText(getApplicationContext(),"You had "+mark+" / "+questions.length+ " correct answers", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                }


            }
        });
    }
    public void starChron(View v){
        if (!running){
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.start();
            running = true;
        }

    }
}
