package com.example.android.paokquizzapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String fanName;

    private boolean question1 = false;
    private boolean question2 = false;
    private boolean question3 = false;
    private boolean question4 = false;
    private boolean question5 = false;
    private boolean question6 = false;
    private boolean question7 = false;

    private int score = 0;

    private RadioButton radio_button1;
    private RadioButton radio_button2;
    private RadioButton radio_button3;
    private RadioButton radio_button4;
    private RadioButton radio_button7;



    private CheckBox checkBox51;
    private CheckBox checkBox52;
    private CheckBox checkBox53;
    private CheckBox checkBox54;


    private CheckBox checkBox61;
    private CheckBox checkBox62;
    private CheckBox checkBox63;
    private CheckBox checkBox64;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radio_button1 = (RadioButton)findViewById(R.id.radio_button13);
        radio_button2 = (RadioButton)findViewById(R.id.radio_button24);
        radio_button3 = (RadioButton)findViewById(R.id.radio_button33);
        radio_button4 = (RadioButton)findViewById(R.id.radio_button41);
        radio_button7 = (RadioButton)findViewById(R.id.radio_button71);


        checkBox51 = (CheckBox)findViewById(R.id.checkbox51);
        checkBox52 = (CheckBox)findViewById(R.id.checkbox52);
        checkBox53 = (CheckBox)findViewById(R.id.checkbox53);
        checkBox54 = (CheckBox)findViewById(R.id.checkbox54);


        checkBox61 = (CheckBox)findViewById(R.id.checkbox61);
        checkBox62 = (CheckBox)findViewById(R.id.checkbox62);
        checkBox63 = (CheckBox)findViewById(R.id.checkbox63);
        checkBox64 = (CheckBox)findViewById(R.id.checkbox64);

    }

    public void compute_result(View view){

        //Gets the name of the fan
        EditText fanNameField = (EditText)findViewById(R.id.name_field);
        fanName = fanNameField.getText().toString();

        //Calls a method which vomputes the score
        compute_score();

        String toastMessage = createResultText();

        //Toast message the result
        Toast toast = Toast.makeText(this, toastMessage, Toast.LENGTH_LONG);
        toast.show();

    }

    public void resetApp(View view){
        fanName = "";

        question1 = false;
        radio_button1.setChecked(false);

        question2 = false;
        radio_button2.setChecked(false);

        question3 = false;
        radio_button3.setChecked(false);

        question4 = false;
        radio_button4.setChecked(false);

        question5 = false;
        checkBox51.setChecked(false);
        checkBox52.setChecked(false);
        checkBox53.setChecked(false);
        checkBox54.setChecked(false);

        question6 = false;
        checkBox61.setChecked(false);
        checkBox62.setChecked(false);
        checkBox63.setChecked(false);
        checkBox64.setChecked(false);

        question7 = false;
        radio_button7.setChecked(false);

        score = 0;

        //Toast message reset
        Toast toast = Toast.makeText(this, "The Score has been reset", Toast.LENGTH_SHORT);
        toast.show();
    }

    public String createResultText(){
        String message;

        message = "Hello "+fanName;
        if(score <2){
            message += "\n"+score+" of 7 - You are not a fan of PAOK!";
        } else if(score <4){
            message += "\n"+score+" of 7 - You have to try more";
        } else if(score<6){
            message += "\n"+score+" of 7 - Good, you are fan of PAOK";
        } else if(score == 6){
            message += "\n"+score+" of 7 - Almost perfect, you are a huge supporter of PAOK";
        } else if(score == 7){
            message += "\n"+score+" of 7 - WOW, you are a fanatic ultra of PAOK, my respects!";
        }
        return message;
    }

    public void compute_score(){
        //Check question 1
        if (radio_button1.isChecked()) {
            question1 = true;
            score += 1;
        }

        //Check question 2
        if (radio_button2.isChecked()) {
            question2 = true;
            score += 1;
        }

        //Check question 3
        if (radio_button3.isChecked()) {
            question3 = true;
            score += 1;
        }

        //Check question 4
        if (radio_button4.isChecked()) {
            question4 = true;
            score += 1;
        }

        //Check question 5
        if(!checkBox51.isChecked() && checkBox52.isChecked() && !checkBox53.isChecked() && checkBox54.isChecked() ){
            question5 = true;
            score += 1;
        }

        //Check question 6
        if(!checkBox61.isChecked() && !checkBox62.isChecked() && checkBox63.isChecked() && checkBox64.isChecked() ){
            question6 = true;
            score += 1;
        }

        //Check question 7
        if (radio_button7.isChecked()) {
            question7 = true;
            score += 1;
        }

    }
}
