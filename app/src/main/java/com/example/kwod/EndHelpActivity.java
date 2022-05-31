package com.example.kwod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EndHelpActivity extends AppCompatActivity {

    public static final String END_HELP_MESSAGE = "END_HELP_MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_help_acitivity);
    }

    public void switch_to_MainActivity(View view)
    {
        launchMainActivity(view);
    }

    public void launchMainActivity(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        String end_message ="end_message";
        intent.putExtra(END_HELP_MESSAGE, end_message);
        startActivity(intent);
        this.finish();
    }
}