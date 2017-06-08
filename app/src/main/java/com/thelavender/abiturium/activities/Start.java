package com.thelavender.abiturium.activities;

import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.thelavender.abiturium.R;

public class Start extends AppCompatActivity {

    private Handler moveToApp = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getSupportActionBar().hide();
        moveToApp.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Start.this, NavDrawerActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}
