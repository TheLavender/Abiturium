package com.thelavender.abiturium.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.thelavender.abiturium.R;
import com.thelavender.abiturium.classes.Olympiad;

import java.util.ArrayList;

public class StartActivity extends AppCompatActivity {

    private Handler moveToApp = new Handler();

    // here is storage
        ArrayList<Olympiad> olympiads = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getSupportActionBar().hide();

        // initializing olympiads
        Olympiad olympiad = new Olympiad();

        // go to MainActivity
        moveToApp.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1500);
    }
}
