package com.example.luncher;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.luncher.Books.Practical;
import com.example.luncher.Mathematics.BMI.BMI;
import com.example.luncher.Mathematics.Calculator;
import com.example.luncher.Mathematics.Mathematics;
import com.example.luncher.Mathematics.Root_calculator;
import com.google.android.material.navigation.NavigationView;


public class Home extends AppCompatActivity {

    ActionBarDrawerToggle drawer_toggle ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Set title to false AFTER toolbar has been set
        try
        {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        catch (NullPointerException e){}

        //Removing underline
        SearchView searchView = findViewById(R.id.searchview);
        int searchPlateId = searchView.getContext().getResources().getIdentifier(
                "android:id/search_plate", null, null);
        View searchPlate = searchView.findViewById(searchPlateId);
        if (searchPlate!=null) {
            searchPlate.setBackgroundColor (Color.TRANSPARENT);
            int searchTextId = searchPlate.getContext ().getResources ().getIdentifier (
                    "android:id/search_src_text", null, null);
        }

        DrawerLayout drawerLayout =findViewById(R.id.drawer_l);
        drawer_toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.setDrawerListener(drawer_toggle);
        drawer_toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        int id = item.getItemId();
                        if (id == R.id.calculator_m){
                            go_calculator();
                        }
                        if (id == R.id.exit_d){
                            finishAffinity();
                        }
                        return false;
                    }
                }
        );


        ViewFlipper viewFlipper = findViewById(R.id.viewflipper);
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(4000);

        Button practical = findViewById(R.id.practical);
        practical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_practical();
            }
        });

        LinearLayout practical_AD = findViewById(R.id.practical_layout);
        practical_AD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_practical();
            }
        });

        Button practical_sAD = findViewById(R.id.practical_ad);
        practical_sAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_practical();
            }
        });

        Button practical_ssAD = findViewById(R.id.practial_sad);
        practical_ssAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_practical();
            }
        });

        Button bmi_ssAD = findViewById(R.id.bmi_ad);
        bmi_ssAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_bmi();
            }
        });

        Button bmi_AD = findViewById(R.id.bmi_sad);
        bmi_AD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_bmi();
            }
        });


        Button roots = findViewById(R.id.roots);
        roots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_roots();
            }
        });

        Button roots_sAD = findViewById(R.id.roots_sad);
        roots_sAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_roots();
            }
        });

        Button roots_AD = findViewById(R.id.roots_ad);
        roots_sAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_roots();
            }
        });

        Button Math_Ban = findViewById(R.id.math_dash_ban);
        Math_Ban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_math();
            }
        });

        Button practical_Ban = findViewById(R.id.prac_dash_ban);
        practical_Ban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_practical();
            }
        });

        Button Math_pos = findViewById(R.id.mathematics_poster);
        Math_pos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_math();
            }
        });


        Button calculator_poster = findViewById(R.id.calculator_poster);
        calculator_poster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_calculator();
            }
        });

        Button bmi_go = findViewById(R.id.bmi_go);
        bmi_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_bmi();
            }
        });

    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(drawer_toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void go_practical(){
        Intent goto_practical = new Intent(this, Practical.class);
        startActivity(goto_practical);
    }

    public void go_bmi(){
        Intent goto_bmi = new Intent(this, BMI.class);
        startActivity(goto_bmi);
    }

    public void go_roots(){
        Intent goto_roots = new Intent(this, Root_calculator.class);
        startActivity(goto_roots);
    }

    public void go_math(){
        Intent goto_math = new Intent(this, Mathematics.class);
        startActivity(goto_math);
    }

    public void go_calculator(){
        Intent goto_calculator = new Intent(this, Calculator.class);
        startActivity(goto_calculator);
    }

}
