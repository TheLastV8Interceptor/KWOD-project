package com.example.kwod;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String MAIN_MESSAGE = "com.example.android.psychoapp.main.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String message = intent.getStringExtra(EndHelpActivity.END_HELP_MESSAGE);
    }

    public void switch_to_accident(View view)
    {
        launchAccidentActivity(view);
    }

    public void launchAccidentActivity(View view)
    {
        Intent intent = new Intent(this, AccidentActivity.class);
        String main_message ="main_message";
        intent.putExtra(MAIN_MESSAGE, main_message);
        startActivity(intent);
        this.finish();
    }

}