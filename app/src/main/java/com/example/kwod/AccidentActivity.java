package com.example.kwod;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class AccidentActivity extends AppCompatActivity {

    public static final String ACCIDENT_MESSAGE = "accident_message" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accident_acitivity);
    }

    public void switch_to_consciousness_activity(View view)
    {
        launchConsciousnessActivity(view);
    }

    public void launchConsciousnessActivity(View view)
    {
        Intent intent = new Intent(this, ConsciousnessActivity.class);
        String accident_message ="accident_message";
        intent.putExtra(ACCIDENT_MESSAGE, accident_message);
        startActivity(intent);
        this.finish();
    }
}