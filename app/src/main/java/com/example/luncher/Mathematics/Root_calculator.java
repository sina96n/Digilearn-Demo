package com.example.luncher.Mathematics;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.luncher.R;
import com.google.android.material.textfield.TextInputEditText;

import static java.lang.StrictMath.ceil;
import static java.lang.StrictMath.sqrt;

public class Root_calculator extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root_calculator);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1a1c29")));
        actionBar.setTitle("Roots Calculators");



        Button Submit = findViewById(R.id.submit);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                find_roots();
            }
        });

    }

    public void find_roots(){


        TextInputEditText inputText_a = findViewById(R.id.input_a);
        TextInputEditText inputText_b = findViewById(R.id.input_b);
        TextInputEditText inputText_c = findViewById(R.id.input_c);

        String test_a = inputText_a.getText().toString();
        String test_b = inputText_b.getText().toString();
        String test_c = inputText_c.getText().toString();

        if (test_a.isEmpty()){
            Toast.makeText(this, "Please Enter a Value for ' a ' ", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (test_b.isEmpty()){
            Toast.makeText(this, "Please Enter a Value for ' b ' ", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (test_c.isEmpty()){
            Toast.makeText(this, "Please Enter a Value for ' c ' ", Toast.LENGTH_SHORT).show();
            return;
        }

        int a = Integer.parseInt(inputText_a.getText().toString());
        int b = Integer.parseInt(inputText_b.getText().toString());
        int c = Integer.parseInt(inputText_c.getText().toString());


        final float Delta = (b*b)-(4*a*c);

        final float x = (-b)/(2*a);
        final float x1 = (float) ((-b + sqrt(Delta))/(2*a));
        final float x2 = (float) ((-b - sqrt(Delta))/(2*a));


        if (Delta>0){
            int c_x1 = Integer.valueOf((int) ceil(x1));
            int c_x2 = Integer.valueOf((int) ceil(x2));
            if ((c_x1 == x1) & (c_x2 == x2)) {
                String R1 = "Your equation answers are : " + c_x1 + " & " + c_x2;
                TextView RESULT = findViewById(R.id.result);
                RESULT.setText(R1);
            }
            else {
                String R1 = "Your equation answers are : " + x1 + " & " + x2;
                TextView RESULT = findViewById(R.id.result);
                RESULT.setText(R1);
            }
        }
        else if (Delta<0){
            String R2=  "Your equation doesn't have any answers !";
            TextView RESULT = findViewById(R.id.result);
            RESULT.setText(R2);
        }
        else {
            double c_x = ceil(x);
            if (c_x == x) {
                String R3 = "Your equation answer is : " + c_x;
                TextView RESULT = findViewById(R.id.result);
                RESULT.setText(R3);
            }
            else {
                String R3 = "Your equation answer is : " + x;
                TextView RESULT = findViewById(R.id.result);
                RESULT.setText(R3);
            }
        }

        return;
    }

}
