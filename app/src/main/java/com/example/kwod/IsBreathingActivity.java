package com.example.kwod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IsBreathingActivity extends AppCompatActivity {

    public static final String IS_BREATHING_MESSAGE = "IS_BREATHING_MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_is_breathing);
    }

    public void switch_to_EndHelpActivity(View view)
    {
        launchEndHelpActivity(view);
    }

    public void launchEndHelpActivity(View view)
    {
        Intent intent = new Intent(this, EndHelpActivity.class);
        String Is_Breathing_message ="Is_Breathing_message";
        intent.putExtra(IS_BREATHING_MESSAGE, Is_Breathing_message);
        startActivity(intent);
        this.finish();
    }
}