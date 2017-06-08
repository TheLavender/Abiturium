package com.thelavender.abiturium.classes;


import com.thelavender.abiturium.classes.Faculty;

import java.util.ArrayList;

public class University
{
    public int ID;
    public String name;
    public String about;
    public ArrayList<Faculty> faculties;
    public ArrayList<String> links;

    public University()
    {
        ID = 0;
        name = "The best Faculty";
        about = "The very best and super Faculty";
        faculties = null;
        links = null;
    }
}
