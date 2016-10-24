package com.giveandget.giveandget;

import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<Events> events= new ArrayList<>();
        events.add(new Events("Crossroads","http://www.globalhand.org/system/images/f86ef52535e9c02e07b3c5fc1bb7b17aee47a3" +
                "21/original/Crossroads%20Foundation_landscape_colour.jpg?1422522062",
                "Poverty","Apply to be a volunteer at and help distribute goods to the needy","27 July 2016"));
        events.add(new Events("Food Angel Volunteering",
                "http://www.foodangel.org.hk/img/logo.jpg","Poverty","Please sign up and help feed the people of Hong Kong",
                "30 July 2016"));
        events.add(new Events("Sample Education NGO","http://topnews.in/law/files/maharashtra-schools.jpg","Education",
                "Help educate the community together!","30 July 2016"));
        events.add(new Events("Another Sample Education NGO","http://www.livemint.com/rf/Image-621x414/LiveMint/Per" +
                "iod1/2013/12/06/Photos/School%20--621x414.jpg","Education", "Help educate the community together!","1 August 2016"));
        events.add(new Events("Environment Conservation Initiative","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFoMqI6Yg" +
                "iDBc1QQJX9vcF33Ise-vOsIscp91scrSD2airn86caQ","Environment","Save the environment","1 August 2016"));
        SharedPreferences eventsSharedPreferences;
        eventsSharedPreferences=getSharedPreferences("events",MODE_PRIVATE);
        String updatedEventsListString = new Gson().toJson(events);
        SharedPreferences.Editor editor = eventsSharedPreferences.edit();
        editor.putString("eventsList", updatedEventsListString);
        editor.apply();
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), MainActivity.this));
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(1);
    }
}
