package com.example.kwod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Stayin_alive extends AppCompatActivity {

    public static final String STAYIN_ALIVE_MESSAGE = "STAYIN_ALIVE_MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stayin_alive);
    }

    public void switch_to_EndHelpActivity(View view)
    {
        launchEndHelpActivity(view);
    }

    public void launchEndHelpActivity(View view)
    {
        Intent intent = new Intent(this, EndHelpActivity.class);
        String stayin_alive_message ="stayin_alive_message";
        intent.putExtra(STAYIN_ALIVE_MESSAGE, stayin_alive_message);
        startActivity(intent);
        this.finish();
    }
}