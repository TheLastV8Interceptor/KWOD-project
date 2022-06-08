package com.example.kwod;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kwod.fragment.IsBreathingCallFragment;
import com.example.kwod.fragment.IsBreathingRecoveryPositionFragment;

import java.util.ArrayList;

public class IsBreathingActivity extends AppCompatActivity {

    private Button isBreathingBackButton;
    private Button isBreathingNextButton;

    private ArrayList<Fragment> isBreathingFragmentList = new ArrayList<>();
    private Integer position = 0;

    public static final String IS_BREATHING_MESSAGE = "IS_BREATHING_MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_is_breathing);

        isBreathingFragmentList.add(new IsBreathingCallFragment());
        isBreathingFragmentList.add(new IsBreathingRecoveryPositionFragment());

        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                .replace(R.id.isBreathingFragment, new IsBreathingCallFragment())
                .commit();

        isBreathingBackButton = findViewById(R.id.isBreathingBackButton);
        isBreathingNextButton = findViewById(R.id.isBreathingNextButton);

        isBreathingBackButton.setOnClickListener(v -> {
            position = Math.abs((position - 1) % isBreathingFragmentList.size());
            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                    .replace(R.id.isBreathingFragment, isBreathingFragmentList.get(position))
                    .commit();
        });
        isBreathingNextButton.setOnClickListener(v -> {
            position = Math.abs((position + 1) % isBreathingFragmentList.size());

            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                    .replace(R.id.isBreathingFragment, isBreathingFragmentList.get(position))
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