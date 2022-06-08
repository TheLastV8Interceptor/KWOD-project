package com.example.kwod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kwod.fragment.IsBreathingCallFragment;
import com.example.kwod.fragment.IsBreathingRecoveryPositionFragment;

public class IsBreathingActivity extends AppCompatActivity {

    private Button isBreathingBackButton;
    private Button isBreathingNextButton;

    public static final String IS_BREATHING_MESSAGE = "IS_BREATHING_MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_is_breathing);

        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                .replace(R.id.isBreathingFragment, new IsBreathingCallFragment())
                .commit();


        isBreathingBackButton = findViewById(R.id.isBreathingBackButton);
        isBreathingNextButton = findViewById(R.id.isBreathingNextButton);

        isBreathingNextButton.setOnClickListener(v -> {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                    .replace(R.id.isBreathingFragment, new IsBreathingRecoveryPositionFragment())
                    .commit();
        });
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