package com.giveandget.giveandget;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Tavish on 23-Jul-16.
 */
public class EventsActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_fragment);
        String tag= getIntent().getStringExtra("tag");
        SharedPreferences eventsSharedPreferences;
        eventsSharedPreferences=getSharedPreferences("events",MODE_PRIVATE);
        String eventString= eventsSharedPreferences.getString("eventsList", null);
        Type type = new TypeToken<ArrayList<Events>>() {
        }.getType();
        ArrayList<Events> eventsList = new Gson().fromJson(eventString, type);
        ArrayList<Events> tempList= new ArrayList<>();
        int size=eventsList.size();
        for(int i=0;i<size;i++)
        {
            if(eventsList.get(i).getTag().equals(tag))
            {
                tempList.add(eventsList.get(i));
            }
        }
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerId);
        final LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        EventsAdapter adapter= new EventsAdapter(this);
        recyclerView.setAdapter(adapter);
        adapter.setEvents_upcoming_list(tempList);
    }
}
