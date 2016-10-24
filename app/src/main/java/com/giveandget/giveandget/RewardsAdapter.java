package com.giveandget.giveandget;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

import java.util.ArrayList;

/**
 * Created by Tavish on 24-Jul-16.
 */
public class RewardsAdapter extends RecyclerView.Adapter <RewardsAdapter.ViewHolderActivityList> {

    private ArrayList<Rewards> rewardList = new ArrayList<>();
    private LayoutInflater activityLayoutInflater;
    private VolleySingleton mySingleton;
    private ImageLoader imageLoader;

    public RewardsAdapter(Context context) {
        activityLayoutInflater = LayoutInflater.from(context);
        mySingleton = VolleySingleton.getInstance(context);
        imageLoader = mySingleton.getImageLoader();
    }

    public void setActivityList(ArrayList<Rewards> rewardList) {
        this.rewardList = rewardList;
        notifyItemRangeChanged(0, rewardList.size());
    }

    @Override
    public ViewHolderActivityList onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = activityLayoutInflater.inflate(R.layout.reward_item, parent, false);
        return new ViewHolderActivityList(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolderActivityList holder, int position) {
        Rewards reward = rewardList.get(position);
        holder.mreward_name.setText(reward.getName());
        String image_url = reward.getPhoto_url();
        if (image_url != null) {
            imageLoader.get(image_url, new ImageLoader.ImageListener() {
                @Override
                public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                    holder.mreward_image.setImageBitmap(response.getBitmap());
                }

                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
        }
    }

    class ViewHolderActivityList extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView mreward_image;
        private TextView mreward_name;

        public ViewHolderActivityList(final View itemView)
        {
            super(itemView);
            mreward_image = (ImageView) itemView.findViewById(R.id.reward_image);
            mreward_name = (TextView) itemView.findViewById(R.id.reward_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent  intent= new Intent(v.getContext(),RedeemActivity.class);
            intent.putExtra("photo",rewardList.get(getAdapterPosition()).getPhoto_url());
            v.getContext().startActivity(intent);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return rewardList.size();
    }
}
