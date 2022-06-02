package com.example.kwod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BreathCheckActivity extends AppCompatActivity {

    public static final String BREATH_CHECK_MESSAGE = "breath_check_message" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breath_check);
    }

    public void switch_to_Is_Breathing(View view)
    {
        launchIsBreathingActivity(view);
    }

    public void switch_to_Is_not_Breathing(View view)
    {
        launchIsNotBreathingActivity(view);
    }

    public void launchIsBreathingActivity(View view)
    {
        Intent intent = new Intent(this, IsBreathingActivity.class);
        String Is_Breathing_message ="Is_Breathing_message";
        intent.putExtra(BREATH_CHECK_MESSAGE, Is_Breathing_message);
        startActivity(intent);
        this.finish();
    }

    public void launchIsNotBreathingActivity(View view)
    {
        Intent intent = new Intent(this, IsNotBreathingActivity.class);
        String Breath_check_message ="Breath_check_message";
        intent.putExtra(BREATH_CHECK_MESSAGE, Breath_check_message);
        startActivity(intent);
        this.finish();
    }


}