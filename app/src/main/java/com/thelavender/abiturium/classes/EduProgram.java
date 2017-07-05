package com.thelavender.abiturium.classes;

import java.util.ArrayList;

public class EduProgram {

    public Faculty faculty = null;

    public String name = "";
    public String shortname = "";
    public String info = "";
    public ArrayList <Olympiad> olympiads = new ArrayList<>();
    public ArrayList <String> links = new ArrayList<>();

    public EduProgram() {
        name = "";
        shortname = "";
        info = "";
        olympiads = new ArrayList<>();
        links = new ArrayList<>();
    }

    public EduProgram(String name, String shortname, String info, ArrayList<Olympiad> olympiads, ArrayList<String> links) {
        this.name = name;
        this.shortname = shortname;
        this.info = info;
        this.olympiads = olympiads;
        this.links = links;
    }

    public EduProgram(String name, String shortname, ArrayList<Olympiad> olympiads, ArrayList<String> links) {
        this.name = name;
        this.shortname = shortname;
        //this.info = info;
        this.olympiads = olympiads;
        this.links = links;
    }

    public EduProgram(String name, String shortname, String info, ArrayList<Olympiad> olympiads) {
        this.name = name;
        this.shortname = shortname;
        this.info = info;
        this.olympiads = olympiads;
        //this.links = new ArrayList<String>();
    }

    public EduProgram(String name, String shortname, ArrayList<Olympiad> olympiads) {
        this.name = name;
        this.shortname = shortname;
        //this.info = info;
        this.olympiads = olympiads;
        //this.links = new ArrayList<String>();
    }
}