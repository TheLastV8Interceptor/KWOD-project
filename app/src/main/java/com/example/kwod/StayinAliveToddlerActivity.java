package com.example.kwod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StayinAliveToddlerActivity extends AppCompatActivity {

    public static final String STAYIN_ALIVE_TODDLER_MESSAGE = "STAYIN_ALIVE_TODDLER_MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stayin_alive_toddler);
    }

    public void switch_to_EndHelpActivity(View view)
    {
        launchEndHelpActivity(view);
    }

    public void launchEndHelpActivity(View view)
    {
        Intent intent = new Intent(this, EndHelpActivity.class);
        String stayin_alive_toddler_message ="stayin_alive_toddler_message";
        intent.putExtra(STAYIN_ALIVE_TODDLER_MESSAGE, stayin_alive_toddler_message);
        startActivity(intent);
        this.finish();
    }
}