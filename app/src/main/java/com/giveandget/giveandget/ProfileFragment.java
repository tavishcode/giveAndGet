package com.giveandget.giveandget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Tavish on 23-Jul-16.
 */
public class ProfileFragment extends Fragment {
    private ListView mExperienceList;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view= inflater.inflate(R.layout.profile_fragment, container, false);
        mExperienceList= (ListView)view.findViewById(R.id.experienceList);
        ArrayList<Companies> NgoList= new ArrayList<>();
        NgoList.add(new Companies("Charity A","https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9" +
                "GcQZv1XFP9E-oFSswbN6yaJ0cl4iW6J_2babkmEy0vbzdvWO9LGBXQ",4));
        NgoList.add(new Companies("Charity B","https://s-media-cache-ak0.pinimg.com/236x/86/d3/33/86d3" +
                "335691a512158574d2bd536b1f5b.jpg",5));
        NgoList.add(new Companies("Charity C","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTRtYN" +
                "Viics6Qh9EGWCBmv-O-3pqwRNQkGJlrmre80106oicwAt",3));
        CompaniesAdapter adapter= new CompaniesAdapter(getActivity(),NgoList);
        mExperienceList.setAdapter(adapter);
        return view;
    }
}
