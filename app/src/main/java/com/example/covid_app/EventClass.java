package com.example.covid_app;

public class EventClass {


    int  ID;
    String title;
    String desciption;
    String date;
    String time;
    boolean check;


    public EventClass(int  ID, String title, String desciption, String date, String time, boolean check) {

        this.ID=ID;
        this.title=title;
        this.desciption=desciption;
        this.date = date;
        this.time=time;
        this.check=check;

    }

    public String gettitle() {

        return title;
    }

    public String getDate() {

        return date;
    }

    public String getTime() {

        return time;
    }

    public boolean isSelected() {

        return check;
    }
}
