package com.giveandget.giveandget;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

import java.util.ArrayList;

/**
 * Created by Tavish on 24-Jul-16.
 */
public class EventDetails extends AppCompatActivity {
    private TextView mEvent_name;
    private TextView mEvent_des;
    private TextView mEvent_date;
    private ImageView mEvent_photo;
    private Button mApplyButton;
    private EditText editText;
    private ListView mCorporateList;
    private VolleySingleton volleySingleton;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_details);
        volleySingleton=VolleySingleton.getInstance(this);
        ImageLoader imageLoader= volleySingleton.getImageLoader();
        mEvent_name= (TextView)findViewById(R.id.event_name);
        mEvent_date= (TextView)findViewById(R.id.event_date);
        mEvent_des= (TextView)findViewById(R.id.event_description);
        mEvent_photo= (ImageView)findViewById(R.id.event_image);
        mApplyButton= (Button)findViewById(R.id.applyButton);
        mApplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Intent intent= new Intent(v.getContext(), VolunteerForm.class);
                startActivityForResult(intent, 1);
            }
        });
        mCorporateList= (ListView)findViewById(R.id.corporateList);
        mEvent_name.setText(getIntent().getStringExtra("eventName"));
        mEvent_date.setText(getIntent().getStringExtra("eventDate"));
        mEvent_des.setText(getIntent().getStringExtra("eventDes"));
        imageLoader.get(getIntent().getStringExtra("eventPhoto"), new ImageLoader.ImageListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }

            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                mEvent_photo.setImageBitmap(response.getBitmap());
            }
        });
        ArrayList<Companies> companyList= new ArrayList<>();
        companyList.add(new Companies("Spacious","https://lh5.ggpht.com/5d4GWQbO0Kh9CaEEAAmEoz3pyzIqcYlD8Rp3A" +
                "1i6smvymmMHJJ0o77Y3tg8OALWJD3kJ=w300",5));
        CompaniesAdapter companiesAdapter= new CompaniesAdapter(this,companyList);
        mCorporateList= (ListView)findViewById(R.id.corporateList);
        mCorporateList.setAdapter(companiesAdapter);
    }
    @Override
    public void onActivityResult(final int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1)
        {
            if (resultCode == RESULT_OK)
            {
                Toast.makeText(this,"Application Sent!",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this,"Application Cancelled!",Toast.LENGTH_SHORT).show();
            }
        }
        }
}
