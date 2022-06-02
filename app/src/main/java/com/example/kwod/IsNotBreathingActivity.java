package com.example.kwod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IsNotBreathingActivity extends AppCompatActivity {

    public static final String IS_NOT_BREATHING_MESSAGE = "IS_BREATHING_MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_is_not_breathing);
    }

    public void switch_to_Emergency_call_activity(View view)
    {
        launchEmergencyCallActivity(view);
    }

    public void launchEmergencyCallActivity(View view)
    {
        Intent intent = new Intent(this, EmergencyCallActivity.class);
        String Is_not_Breathing_message ="Is_not_Breathing_message";
        intent.putExtra(IS_NOT_BREATHING_MESSAGE, Is_not_Breathing_message);
        startActivity(intent);
        this.finish();
    }
}