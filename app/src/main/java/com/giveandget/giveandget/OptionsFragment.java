package com.giveandget.giveandget;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Tavish on 23-Jul-16.
 */
public class OptionsFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view= inflater.inflate(R.layout.options_fragment, container, false);
        final String[] items= new String[]{"Poverty","Education","Environment"};
        final ListView options= (ListView)view.findViewById(R.id.optionList);
        ArrayAdapter<String> itemsAdapter =
        new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);
        options.setAdapter(itemsAdapter);
        options.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(getActivity(),EventsActivity.class);
                intent.putExtra("tag", items[position]);
                startActivity(intent);
            }
        });
        return view;
    }
}
