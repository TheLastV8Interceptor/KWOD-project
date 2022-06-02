package com.example.kwod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UnconsciousActivity extends AppCompatActivity
{

    public static final String UNCONSCIOUS_MESSAGE = "unconscious_message" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unconscious);
    }

    public void switch_to_Breath_check(View view)
    {
        launchBreathCheckActivity(view);
    }


    public void launchBreathCheckActivity(View view)
    {
        Intent intent = new Intent(this, BreathCheckActivity.class);
        String Unconscious_message ="Unconscious_message";
        intent.putExtra(UNCONSCIOUS_MESSAGE, Unconscious_message);
        startActivity(intent);
        this.finish();
    }

}
