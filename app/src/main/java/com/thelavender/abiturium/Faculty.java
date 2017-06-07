package com.thelavender.abiturium;

import java.util.ArrayList;

public class Faculty
{
    public int ID;
    public int UniID;

    public String name;
    public String about;
    public ArrayList<String> links;

    public ArrayList<EduProgram> eduprograms;

    public Faculty()
    {
        name = "The best Faculty";
        about = "The very best and super Faculty";
        eduprograms = null;
        links = null;
    }
}
