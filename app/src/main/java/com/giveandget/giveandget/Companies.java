package com.giveandget.giveandget;

/**
 * Created by Tavish on 24-Jul-16.
 */
public class Companies {
    private String name;
    private String photo_url;
    private int rating;

    Companies(String n, String p, int r) {
        name = n;
        photo_url = p;
        rating = r;
    }

    public String getName() {
        return name;
    }

    public String getPhoto_url() {
        return photo_url;
    }
    public int getRating()
    {
        return rating;
    }
}
