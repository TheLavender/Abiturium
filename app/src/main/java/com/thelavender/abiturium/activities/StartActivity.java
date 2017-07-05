package com.thelavender.abiturium.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.query.Predicate;
import com.thelavender.abiturium.R;
import com.thelavender.abiturium.classes.DataB;
import com.thelavender.abiturium.classes.EduProgram;
import com.thelavender.abiturium.classes.Faculty;
import com.thelavender.abiturium.classes.OlympEvent;
import com.thelavender.abiturium.classes.Olympiad;
import com.thelavender.abiturium.classes.University;
import com.thelavender.abiturium.enums.Category;
import com.thelavender.abiturium.fragments.Calendar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;

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
        //Connecting to database and configuring it
        EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();

        config.common().objectClass(DataB.class).cascadeOnActivate(true);
        config.common().objectClass(University.class).cascadeOnActivate(true);
        config.common().objectClass(Faculty.class).cascadeOnActivate(true);
        config.common().objectClass(EduProgram.class).cascadeOnActivate(true);
        config.common().objectClass(Olympiad.class).cascadeOnActivate(true);
        config.common().objectClass(OlympEvent.class).cascadeOnActivate(true);
        config.common().activationDepth(6);

        config.common().objectClass(DataB.class).cascadeOnUpdate(true);
        config.common().objectClass(University.class).cascadeOnUpdate(true);
        config.common().objectClass(Faculty.class).cascadeOnUpdate(true);
        config.common().objectClass(EduProgram.class).cascadeOnUpdate(true);
        config.common().objectClass(Olympiad.class).cascadeOnUpdate(true);
        config.common().objectClass(OlympEvent.class).cascadeOnUpdate(true);
        config.common().updateDepth(6);

        File file = new File(this.getFilesDir(), "special.data");
        InputStream inputStream = getResources().openRawResource(getResources().getIdentifier("special", "raw", getPackageName()));
        String s = convertStreamToString(inputStream);
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        OutputStreamWriter outputStreamWriter = null;
        try {
            outputStreamWriter = new OutputStreamWriter(openFileOutput("special.data", MODE_PRIVATE));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            outputStreamWriter.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStreamWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (file.exists()) {
            Log.d("file", "eee");
        }

        String res = "";
        InputStream inputStream1 = null;
        try {
            inputStream1 = openFileInput("special.data");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            if (inputStream1 != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream1);
                StringBuilder stringBuilder = new StringBuilder();

                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String l;
                while ((l = bufferedReader.readLine()) != null) {
                    res += l;
                    res += '\n';
                }
                bufferedReader.close();

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream1 != null)
                    inputStream1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Log.d("size", res);

        File file1 = new File(getDir("data", 0) + "/special.data");
        if (file1.exists()) {
            Log.d("qqq", "111");
        } else {
            Log.d("qqq", "222");
        }

        ObjectContainer db4objects = Db4oEmbedded.openFile(config, getDir("data", 0) + "/special.data");

        // Getting object from the database
        DataB db = db4objects.query(new Predicate<DataB>() {
            @Override
            public boolean match(DataB target) {
                return true;
            }
        }).next();
        db4objects.close();

        olympiads = new ArrayList<>(db.olympiads);
        universities = new ArrayList<>(db.universities);
    }

    static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
