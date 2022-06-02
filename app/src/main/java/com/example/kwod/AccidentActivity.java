package com.example.kwod;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class AccidentActivity extends AppCompatActivity {

    public static final String ACCIDENT_MESSAGE = "accident_message" ;
    public static final Integer RecordAudioRequestCode = 1;
    private SpeechRecognizer speechRecognizer;
    Intent intent;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accident);
        intent = getIntent();

        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            checkPermission();
        }

        speechRecognizer.startListening(intent);

        speechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle bundle) {

            }

            @Override
            public void onBeginningOfSpeech()
            {
                //editText.setText("");
            }

            @Override
            public void onRmsChanged(float v) {

            }

            @Override
            public void onBufferReceived(byte[] bytes) {

            }

            @Override
            public void onEndOfSpeech() {
                speechRecognizer.startListening(intent);
            }

            @Override
            public void onError(int i) {
                //speechRecognizer.destroy();
                //speechRecognizer = null;
                speechRecognizer.startListening(intent);

            }

            @Override
            public void onResults(Bundle bundle) {
                ArrayList<String> data = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                String bestResult = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION).get(0);

                Log.d("AccidentActivity", bestResult);
                if(bestResult.equals("RKO") || bestResult.equals("RKO") || bestResult.equals("RKO"))
                {
                    switch_to_consciousness_activity(view);
                }
            }

            @Override
            public void onPartialResults(Bundle bundle) {
                ArrayList<String> data = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                String bestResult = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION).get(0);
                Log.d("AccidentActivity", bestResult);
                if(bestResult.equals("RKO") || bestResult.equals("RKO") || bestResult.equals("RKO"))
                {
                    switch_to_consciousness_activity(view);
                }
            }

            @Override
            public void onEvent(int i, Bundle bundle) {

            }

        });

    }

    private void checkPermission()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECORD_AUDIO},RecordAudioRequestCode);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == RecordAudioRequestCode && grantResults.length > 0 ){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this,"Permission Granted",Toast.LENGTH_SHORT).show();
            }

        }
    }

    private void StartListening(Intent intent) {
        speechRecognizer.setRecognitionListener((RecognitionListener) this);
        intent.setAction(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

    }

    public void switch_to_consciousness_activity(View view)
    {
        launchConsciousnessActivity(view);
    }

    public void launchConsciousnessActivity(View view)
    {
        speechRecognizer.destroy();
        Intent intent = new Intent(this, ConsciousnessActivity.class);
        String accident_message ="accident_message";
        intent.putExtra(ACCIDENT_MESSAGE, accident_message);
        startActivity(intent);
        this.finish();
    }
}