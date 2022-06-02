package com.example.kwod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StayinAliveSmallChildActivity extends AppCompatActivity {

    public static final String STAYIN_ALIVE_SMALL_CHILD_MESSAGE = "STAYIN_ALIVE_SMALL_CHILD_MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stayin_alive_small_child);
    }

    public void switch_to_EndHelpActivity(View view)
    {
        launchEndHelpActivity(view);
    }

    public void launchEndHelpActivity(View view)
    {
        Intent intent = new Intent(this, EndHelpActivity.class);
        String stayin_alive_small_child_message ="stayin_alive_small_child_message";
        intent.putExtra(STAYIN_ALIVE_SMALL_CHILD_MESSAGE, stayin_alive_small_child_message);
        startActivity(intent);
        this.finish();
    }
}