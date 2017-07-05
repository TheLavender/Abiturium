package com.thelavender.abiturium.classes;

import java.util.ArrayList;

public class Faculty {
    public String name = "";
    public String shortname = "";
    public String about = "";
    public ArrayList<EduProgram> eduPrograms = new ArrayList<>();
    public ArrayList<String> links = new ArrayList<>();

    public Faculty() {}

    public Faculty(String name, String shortname, String about, ArrayList<EduProgram> eduPrograms, ArrayList<String> links) {
        this.name = name;
        this.shortname = shortname;
        this.about = about;
        this.eduPrograms = eduPrograms;
        this.links = links;
    }

    public Faculty(String name, String shortname, ArrayList<EduProgram> eduPrograms, ArrayList<String> links) {
        this.name = name;
        this.shortname = shortname;
        //this.about = about;
        this.eduPrograms = eduPrograms;
        this.links = links;
    }

    public Faculty(String name, String shortname, String about, ArrayList<EduProgram> eduPrograms) {
        this.name = name;
        this.shortname = shortname;
        this.about = about;
        this.eduPrograms = eduPrograms;
        //this.links = links;
    }

    public Faculty(String name, String shortname, ArrayList<EduProgram> eduPrograms) {
        this.name = name;
        this.shortname = shortname;
        //this.about = about;
        this.eduPrograms = eduPrograms;
        //this.links = links;
    }
}
