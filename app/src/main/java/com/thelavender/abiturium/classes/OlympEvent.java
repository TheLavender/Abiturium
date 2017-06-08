package com.thelavender.abiturium.classes;


import com.thelavender.abiturium.enums.Category;

import java.util.Calendar;


public class OlympEvent
{
    public int ID;
    public int OlyID;

    public Category cat;
    public String name;
    public String info;

    public boolean immediate = false;
    public Calendar begin;
    public Calendar end;

    public boolean hidden = false;
    public boolean done = false;
}