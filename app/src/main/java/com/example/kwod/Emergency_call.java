package com.example.kwod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Emergency_call extends AppCompatActivity {

    public static final String EMERGENCY_CALL_MESSAGE = "EMERGENCY_CALL_MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_call);
    }

    public void switch_to_StayinAlive(View view)
    {
        launchStayinAliveActivity(view);
    }

    public void switch_to_StayinAliveSmallChild(View view)
    {
        launchStayinAliveSmallChildActivity(view);
    }

    public void switch_to_StayinAliveToddler(View view)
    {
        launchStayinAliveToddlerActivity(view);
    }

    public void launchStayinAliveActivity(View view)
    {
        Intent intent = new Intent(this, Stayin_alive.class);
        String Emergency_call ="Emergency_call_message";
        intent.putExtra(EMERGENCY_CALL_MESSAGE, Emergency_call);
        startActivity(intent);
        this.finish();
    }

    public void launchStayinAliveSmallChildActivity(View view)
    {
        Intent intent = new Intent(this, Stayin_alive_small_child.class);
        String Emergency_call ="Emergency_call_message";
        intent.putExtra(EMERGENCY_CALL_MESSAGE, Emergency_call);
        startActivity(intent);
        this.finish();
    }

    public void launchStayinAliveToddlerActivity(View view)
    {
        Intent intent = new Intent(this, Stayin_alive_small_child.class);
        String Emergency_call ="Emergency_call_message";
        intent.putExtra(EMERGENCY_CALL_MESSAGE, Emergency_call);
        startActivity(intent);
        this.finish();
    }
}