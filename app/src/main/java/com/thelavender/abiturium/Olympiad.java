package com.thelavender.abiturium;

import java.util.ArrayList;

public class Olympiad
{
    public int ID; // our own list of olympiads
    public int PerID; // id of official Russian olympiad list or 0

    public String name;
    public String info;
    public ArrayList<String> links;

    public ArrayList<Subject> subjects;
    public String field;

    public ArrayList<OlympEvent> events;

    public boolean show;
}
