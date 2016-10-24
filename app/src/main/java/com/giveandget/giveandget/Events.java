package com.giveandget.giveandget;

/**
 * Created by Tavish on 23-Jul-16.
 */
public class Events {
    private String name;
    private String photo_url;
    private String tag;
    private String date;
    private String description;
    Events(String n, String p, String t, String des, String d)
    {
        name=n;
        photo_url=p;
        tag=t;
        description=des;
        date=d;
    }
    public String getName()
    {
        return name;
    }
    public String getPhoto_url()
    {
        return photo_url;
    }
    public String getTag()
    {
        return tag;
    }
    public String getDescription(){return description;}
    public String getDate() {return date;}
}
