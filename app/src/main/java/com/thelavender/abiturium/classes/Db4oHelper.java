package com.thelavender.abiturium.classes;

import android.content.Context;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.AndroidSupport;
import com.db4o.config.BigMathSupport;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ext.Db4oException;
import com.db4o.ext.Db4oIOException;
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

public class Db4oHelper {
    public ObjectContainer db4objects = null;
    public DataB db = null;

    public Db4oHelper(String path, Context ctx)
    {
        openDB(path, ctx);
        if (db4objects.queryByExample(DataB.class).size() == 1)
        {
            db = (DataB) db4objects.queryByExample(DataB.class).next();
        }
        else
        {
            throw new Db4oIOException();
        }
    }

    public boolean createDB(String path, Context ctx)
    {
        File file = new File(ctx.getFilesDir() + "/" + path);
        if (file.exists()) return false;
        db4objects = Db4oEmbedded.openFile(getConfig(), ctx.getFilesDir() + "/" + path);
        return true;
    }

    public boolean openDB(String path, Context ctx)
    {
        File file = new File(ctx.getFilesDir() + "/" + path);
        if (!file.exists()) return false;
        db4objects = Db4oEmbedded.openFile(getConfig(), ctx.getFilesDir() + "/" + path);
        return true;
    }

    public static boolean getCopyFromRaw(String nameWOExtension, String path, Context ctx)
    {
        File file = new File(ctx.getFilesDir() + "/" + path);
        try {
            InputStream inputStream = ctx.getResources().openRawResource(ctx.getResources().getIdentifier(nameWOExtension, "raw", ctx.getPackageName()));
            FileUtils.copyInputStreamToFile(inputStream, file);
            inputStream.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public EmbeddedConfiguration getConfig()
    {
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

        return config;
    }
}
