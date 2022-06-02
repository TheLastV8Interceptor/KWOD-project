package com.example.kwod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class conscious extends AppCompatActivity {

    public static final String CONSCIOUS_MESSAGE = "conscious_message" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conscious);
    }

    public void switch_to_EndHelpActivity(View view)
    {
        launchEndHelpActivity(view);
    }

    public void launchEndHelpActivity(View view)
    {
        Intent intent = new Intent(this, EndHelpActivity.class);
        String conscious_message ="conscious_message";
        intent.putExtra(CONSCIOUS_MESSAGE, conscious_message);
        startActivity(intent);
        this.finish();
    }
}