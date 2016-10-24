package com.giveandget.giveandget;

import android.content.Context;
import android.content.Intent;
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
 * Created by Tavish on 23-Jul-16.
 */
public class EventsAdapter extends RecyclerView.Adapter <EventsAdapter.ViewHolderEventList> {

    private ArrayList<Events> events_upcoming_list = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private VolleySingleton mySingleton;
    private ImageLoader imageLoader;

    public EventsAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        mySingleton = VolleySingleton.getInstance(context);
        imageLoader = mySingleton.getImageLoader();
    }

    public void setEvents_upcoming_list(ArrayList<Events> events_upcoming_list) {
        this.events_upcoming_list = events_upcoming_list;
        notifyItemRangeChanged(0,events_upcoming_list.size());
    }

    @Override
    public ViewHolderEventList onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.event_item, parent, false);
        ViewHolderEventList viewHolder = new ViewHolderEventList(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolderEventList holder, int position) {
        Events current_event = events_upcoming_list.get(position);
        Log.d("adapter",current_event.getName());
        Log.d("adapter",current_event.getPhoto_url());
        holder.event_name.setText(current_event.getName());
        String image_url = current_event.getPhoto_url();
        if (image_url != null) {
            imageLoader.get(image_url, new ImageLoader.ImageListener() {
                @Override
                public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                    holder.event_image.setImageBitmap(response.getBitmap());
                }

                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        if (events_upcoming_list != null) {
            return events_upcoming_list.size();
        } else {
            return 0;
        }
    }

    class ViewHolderEventList extends RecyclerView.ViewHolder {
        private ImageView event_image;
        private TextView event_name;

        public ViewHolderEventList(final View itemView) {
            super(itemView);
            event_image = (ImageView) itemView.findViewById(R.id.event_image);
            event_name = (TextView) itemView.findViewById(R.id.event_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(v.getContext(),EventDetails.class);
                    intent.putExtra("eventName", events_upcoming_list.get(getAdapterPosition()).getName());
                    intent.putExtra("eventPhoto", events_upcoming_list.get(getAdapterPosition()).getPhoto_url());
                    intent.putExtra("eventDes", events_upcoming_list.get(getAdapterPosition()).getDescription());
                    intent.putExtra("eventDate",events_upcoming_list.get(getAdapterPosition()).getDate());
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
