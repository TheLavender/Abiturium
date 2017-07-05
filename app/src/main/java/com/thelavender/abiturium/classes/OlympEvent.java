package com.thelavender.abiturium.classes;

import com.thelavender.abiturium.enums.Category;

import java.util.ArrayList;
import java.util.Calendar;


public class OlympEvent {

    public Olympiad olympiad = null;

    public Category cat = null;
    public String name = "";
    public String info = "";
    public ArrayList <String> links = new ArrayList<>();

    public boolean immediate = false;
    public Calendar begin = null;
    public Calendar end = null;

    public boolean hidden = false;
    public boolean done = false;

    public OlympEvent() {}

    public OlympEvent(Category cat, String name, String info, ArrayList<String> links, Calendar begin, Calendar end) {
        this.cat = cat;
        this.name = name;
        this.info = info;
        this.links = links;
        this.begin = begin;
        this.end = end;
    }

    public OlympEvent(Category cat, String name, String info, Calendar begin, Calendar end) {
        this.cat = cat;
        this.name = name;
        this.info = info;
        //this.links = links;
        this.begin = begin;
        this.end = end;
    }

    public OlympEvent(Category cat, String name, ArrayList<String> links, Calendar begin, Calendar end) {
        this.cat = cat;
        this.name = name;
        //this.info = info;
        this.links = links;
        this.begin = begin;
        this.end = end;
    }

    public OlympEvent(Category cat, String name, Calendar begin, Calendar end) {
        this.cat = cat;
        this.name = name;
        //this.info = info;
        //this.links = links;
        this.begin = begin;
        this.end = end;
    }
}