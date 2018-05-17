package com.example.nitin.logicaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class CorrectAnswers extends AppCompatActivity {

    RadioGroup g8,g9,g10;
    RadioButton r8,r9,r10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct_answers);

        g8=(RadioGroup)findViewById(R.id.eight);
        g9=(RadioGroup)findViewById(R.id.nine);
        g10=(RadioGroup)findViewById(R.id.ten);
    }
}
