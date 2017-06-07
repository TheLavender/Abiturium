package com.thelavender.abiturium;


import java.util.ArrayList;

public class EduProgram
{
    public int ID;
    public int FacID;
    public int UniID;
    public String name;
    public String about;
    public ArrayList <String> links;
    public ArrayList <Integer> olympIDs;

    public EduProgram()
    {
        name = "The best educational program";
        about = "Very smart and good program";
        links = null;
        olympIDs = null;
    }
}