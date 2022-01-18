package com.example.luncher.Mathematics;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.luncher.R;

public class Mathematics extends AppCompatActivity {

    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathematics);


        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1a1c29")));
        actionBar.setTitle("Mathematics");

        Button calculator = findViewById(R.id.calculator_m);
        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_calculator();
            }
        });

        ImageButton calculator_b = findViewById(R.id.calculator_b);
        calculator_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_calculator();
            }
        });

    }


    public void go_calculator(){
        Intent goto_calculator = new Intent(this, Calculator.class);
        startActivity(goto_calculator);
    }

}
