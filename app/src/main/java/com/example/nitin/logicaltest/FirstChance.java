package com.example.nitin.logicaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

public class FirstChance extends AppCompatActivity {
    RadioGroup r4,r5,r6,r7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_chance);

        r4=(RadioGroup)findViewById(R.id.four);
        r5=(RadioGroup)findViewById(R.id.five);
        r6=(RadioGroup)findViewById(R.id.six);
        r7=(RadioGroup)findViewById(R.id.seven);
    }
}
