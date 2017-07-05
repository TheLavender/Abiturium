package com.thelavender.abiturium.classes;

import com.thelavender.abiturium.enums.Subject;

import java.util.ArrayList;

public class Olympiad {
    public String name = "";
    public String shortname = "";
    public String info = "";
    public ArrayList<String> links = new ArrayList<>();

    public ArrayList<Subject> subjects = new ArrayList<>();
    public String field = "";

    public ArrayList<OlympEvent> events = new ArrayList<>();

    public Olympiad() {}

    public Olympiad(String shortname, String name, String info, ArrayList<String> links, ArrayList<Subject> subjects, String field, ArrayList<OlympEvent> events) {
        this.name = name;
        this.shortname = shortname;
        this.info = info;
        this.links = links;
        this.subjects = subjects;
        this.field = field;
        this.events = events;
    }

    public Olympiad(String shortname, String name, String info, ArrayList<Subject> subjects, String field, ArrayList<OlympEvent> events) {
        this.name = name;
        this.shortname = shortname;
        this.info = info;
        //this.links = links;
        this.subjects = subjects;
        this.field = field;
        this.events = events;
    }

    public Olympiad(String shortname, String name, ArrayList<String> links, ArrayList<Subject> subjects, String field, ArrayList<OlympEvent> events) {
        this.name = name;
        this.shortname = shortname;
        //this.info = info;
        this.links = links;
        this.subjects = subjects;
        this.field = field;
        this.events = events;
    }

    public Olympiad(String shortname, String name, ArrayList<Subject> subjects, String field, ArrayList<OlympEvent> events) {
        this.name = name;
        this.shortname = shortname;
        //this.info = info;
        //this.links = links;
        this.subjects = subjects;
        this.field = field;
        this.events = events;
    }

    public Olympiad(String shortname, String name, ArrayList<Subject> subjects, ArrayList<OlympEvent> events) {
        this.name = name;
        this.shortname = shortname;
        //this.info = info;
        //this.links = links;
        this.subjects = subjects;
        //this.field = field;
        this.events = events;
    }
}
