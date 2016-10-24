package com.giveandget.giveandget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

import java.util.ArrayList;

/**
 * Created by Tavish on 24-Jul-16.
 */
public class CompaniesAdapter extends ArrayAdapter<Companies>
{
private VolleySingleton mySingleton;
private ImageLoader imageLoader;
private LayoutInflater companyInflater;

static class ViewHolderItem
{
    TextView mcompany_name;
    de.hdodenhof.circleimageview.CircleImageView mcompany_photo;
    RatingBar ratingBar;
}

    public CompaniesAdapter(Context context, ArrayList<Companies> attending_groups)
    {
        super(context, R.layout.company_list_item,attending_groups);
        mySingleton=VolleySingleton.getInstance(context);
        imageLoader=mySingleton.getImageLoader();
    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent)
    {
        final ViewHolderItem holder;
        if(convertView==null)
        {
            companyInflater= LayoutInflater.from(getContext());
            convertView= companyInflater.inflate(R.layout.company_list_item, parent, false);
            holder= new ViewHolderItem();
            holder.mcompany_name= (TextView)convertView.findViewById(R.id.company_name);
            holder.mcompany_photo= (de.hdodenhof.circleimageview.CircleImageView)convertView.findViewById(R.id.company_photo);
            holder.ratingBar= (RatingBar)convertView.findViewById(R.id.ratingBar);
            convertView.setTag(holder);
        }
        else
        {
            holder= (ViewHolderItem) convertView.getTag();
        }
        Companies company= getItem(position);
        holder.mcompany_name.setText(company.getName());
        holder.ratingBar.setRating(company.getRating());
        imageLoader.get(company.getPhoto_url(), new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                holder.mcompany_photo.setImageBitmap(response.getBitmap());
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        return convertView;
    }
}
