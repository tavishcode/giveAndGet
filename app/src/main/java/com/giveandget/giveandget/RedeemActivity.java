package com.giveandget.giveandget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

/**
 * Created by Tavish on 24-Jul-16.
 */
public class RedeemActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView;
    private VolleySingleton volleySingleton;
    private Button redeem;
    private Button cancel;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.redeem);
        volleySingleton= VolleySingleton.getInstance(this);
        ImageLoader imageLoader= volleySingleton.getImageLoader();
        imageView= (ImageView)findViewById(R.id.couponImage);
        redeem= (Button)findViewById(R.id.redeem);
        redeem.setOnClickListener(this);
        cancel= (Button)findViewById(R.id.cancel);
        cancel.setOnClickListener(this);
        Log.d("a",getIntent().getStringExtra("photo"));
        imageLoader.get(getIntent().getStringExtra("photo"), new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                imageView.setImageBitmap(response.getBitmap());
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
        switch (v.getId())
        {
            case R.id.redeem:
                Toast.makeText(v.getContext(),"Voucher Redeemed",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cancel:
                Toast.makeText(v.getContext(),"Voucher Redemption Cancelled!",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
