package com.giveandget.giveandget;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

/**
 * Created by Tavish on 24-Jul-16.
 */
public class VolunteerForm extends AppCompatActivity implements View.OnClickListener {
    private Button mSend;
    private Button mCancel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volunteer_form);
        mSend=(Button)findViewById(R.id.send);
        mSend.setOnClickListener(this);
        mCancel= (Button)findViewById(R.id.cancel);
        mCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        InputMethodManager keyboard = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        keyboard.hideSoftInputFromWindow(v.getWindowToken(), 0);
        switch (v.getId())
        {
            case R.id.send:
                setResult(Activity.RESULT_OK);
                Log.d("a","a");
                finish();
                break;
            case R.id.cancel:
                setResult(Activity.RESULT_CANCELED);
                finish();
                break;
        }
    }
}
