package com.example.luncher.Mathematics.BMI;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.luncher.R;

public class BMI_result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1a1c29")));
        actionBar.setTitle("Body Mass Index");

        Intent intent = getIntent();
        String  weight = intent.getStringExtra("weight_d");
        String bmi = intent.getStringExtra("bmi_d");
        String height = intent.getStringExtra("height_d");

        TextView weight_t = findViewById(R.id.weight_result);
        weight_t.setText(weight);

        TextView bmi_t = findViewById(R.id.bmi_result);
        bmi_t.setText(bmi);

        TextView height_t = findViewById(R.id.height);
        height_t.setText(height + " CM");



    }
}
