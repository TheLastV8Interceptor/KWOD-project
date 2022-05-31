package com.example.kwod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class consciusness_activity extends AppCompatActivity {

    public static final String CONSCIOUSNESS_ACTIVITY_MESSAGE = "consciousness_activity_message" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consciusness);
    }

    public void switch_to_conscious_activity(View view)
    {
        launchConsciousActivity(view);
    }

    public void switch_to_unconscious_activity(View view)
    {
        launchUnconsciousActivity(view);
    }

    public void launchConsciousActivity(View view)
    {
        Intent intent = new Intent(this, conscious.class);
        String consciousness_activity_message ="consciousness_activity_message";
        intent.putExtra(CONSCIOUSNESS_ACTIVITY_MESSAGE, consciousness_activity_message);
        startActivity(intent);
        this.finish();
    }

    public void launchUnconsciousActivity(View view)
    {
        Intent intent = new Intent(this, unconscious.class);
        String consciousness_activity_message ="consciousness_activity_message";
        intent.putExtra(CONSCIOUSNESS_ACTIVITY_MESSAGE, consciousness_activity_message);
        startActivity(intent);
        this.finish();
    }
}