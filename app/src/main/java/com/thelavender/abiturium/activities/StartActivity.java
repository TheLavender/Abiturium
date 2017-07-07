package com.thelavender.abiturium.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.AndroidSupport;
import com.db4o.config.BigMathSupport;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.query.Predicate;
import com.thelavender.abiturium.R;
import com.thelavender.abiturium.classes.Db4oHelper;
import com.thelavender.abiturium_utils.classes.DataB;
import com.thelavender.abiturium_utils.classes.EduProgram;
import com.thelavender.abiturium_utils.classes.Faculty;
import com.thelavender.abiturium_utils.classes.OlympEvent;
import com.thelavender.abiturium_utils.classes.Olympiad;
import com.thelavender.abiturium_utils.classes.University;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class StartActivity extends AppCompatActivity {

    private Handler moveToApp = new Handler();

    // here is storage
    ArrayList<Olympiad> olympiads = new ArrayList<>();
    ArrayList<University> universities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getSupportActionBar().hide();

        getDB();
        //TextView textView = (TextView)findViewById(R.id.start_abit);
        //textView.setText(universities.get(0).name);

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

    void getDB() {

        File dataFile = new File(getFilesDir() + "/" + "data.db4o");
        if (!dataFile.exists())
        {
            if (!Db4oHelper.getCopyFromRaw("data", "data.db4o", this))
            {
                System.out.println("Something is wrong");
            }
        }

        Db4oHelper data = new Db4oHelper("data.db4o", this);
        DataB db = data.db;
        ObjectContainer db4objects = data.db4objects;
    }

    static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
