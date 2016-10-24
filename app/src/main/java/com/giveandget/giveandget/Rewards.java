package com.giveandget.giveandget;

/**
 * Created by Tavish on 24-Jul-16.
 */
public class Rewards {
    private String name;
    private String photo_url;
    Rewards(String n, String p) {
        name = n;
        photo_url = p;
    }
    public String getName()
    {
        return name;
    }
    public String getPhoto_url()
    {
        return photo_url;
    }
}
