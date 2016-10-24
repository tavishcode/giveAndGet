package com.giveandget.giveandget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Tavish on 23-Jul-16.
 */
public class RewardsFragment extends Fragment{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public android.view.View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view= inflater.inflate(R.layout.rewards_fragment, container, false);
        RecyclerView rewardsRecycler=(RecyclerView)view.findViewById(R.id.rewardsRecycler);
        rewardsRecycler.setLayoutManager(new GridLayoutManager(getActivity(),2));
        RewardsAdapter adapter= new RewardsAdapter(getActivity());
        ArrayList<Rewards> rewards= new ArrayList<>();
        rewards.add(new Rewards("Spacious","https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQ4" +
                "QywoKxo8JHuQnT2QXThb85c0C9VHvW55twZI1mGRvFWnPj4sqA"));
        rewards.add(new Rewards("HotelQuickly","http://www.cedars.hku.hk/careersfair/09/img/coupon.gif"));
        rewards.add(new Rewards("Monexo","http://www.infosec.gov.hk/english/promotion/images/cash.gif"));
        adapter.setActivityList(rewards);
        rewardsRecycler.setAdapter(adapter);
        return view;
    }
}
