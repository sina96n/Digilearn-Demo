package com.example.luncher.Mathematics.BMI;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.luncher.R;

public class BMI extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1a1c29")));
        actionBar.setTitle("Body Mass Index");

        spinner = findViewById(R.id.gender);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this,
                R.array.Gender_spinner,
                R.layout.spinner_color
        );
        adapter.setDropDownViewResource(R.layout.spinner_dropdown);
        spinner.setAdapter(adapter);

        Button Done = findViewById(R.id.done);
        Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bmi_result();
            }
        });

    }


    public void bmi_result(){

        Intent intent = new Intent(this , BMI_result.class);

        EditText input_weight = findViewById(R.id.input_weight);
        EditText input_height = findViewById(R.id.input_height);

        String height_test = input_height.getText().toString();
        String weight_test = input_weight.getText().toString();

        if (height_test.isEmpty()){
            Toast.makeText(this, "Please Enter your Height ", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (weight_test.isEmpty()){
            Toast.makeText(this, "Please Enter your Weight ", Toast.LENGTH_SHORT).show();
            return;
        }

        float weight = Integer.parseInt(input_weight.getText().toString());
        float height_cm = Integer.parseInt(input_height.getText().toString());
        float height = height_cm / 100;

        float bmi = (weight) / (height * height);

        String bmi_d = String.valueOf(bmi);
        String weight_d = String.valueOf(Math.ceil(weight));
        String height_d = String.valueOf(height_cm);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        intent.putExtra("bmi_d" , bmi_d);
        intent.putExtra("weight_d" , weight_d);
        intent.putExtra("height_d" , height_d);

        startActivity(intent);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
