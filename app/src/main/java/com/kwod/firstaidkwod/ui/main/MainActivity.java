package com.kwod.firstaidkwod.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.kwod.firstaidkwod.R;
import com.kwod.firstaidkwod.ui.example.ExampleActivity;

public class MainActivity extends AppCompatActivity {


    private Button exampleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exampleButton = findViewById(R.id.exampleButton);
        exampleButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, ExampleActivity.class);
            startActivity(intent);
        });
    }
}