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

        config.common().add(new AndroidSupport());
        config.common().add(new BigMathSupport());

        File file = new File(getFilesDir(), "/special.data");
        try {
            InputStream inputStream = getResources().openRawResource(getResources().getIdentifier("special", "raw", getPackageName()));
            FileUtils.copyInputStreamToFile(inputStream, file);
            inputStream.close();
        } catch (IOException e) {
            System.exit(0);
        }

        ObjectContainer db4objects = Db4oEmbedded.openFile(config, getFilesDir() + "/special.data");

        // Getting object from the database
        DataB db = (DataB) db4objects.queryByExample(DataB.class).next();
        db4objects.close();
    }

    static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
