package com.example.kwod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class ConsciousnessActivity extends AppCompatActivity {

    public static final String CONSCIOUSNESS_ACTIVITY_MESSAGE = "consciousness_activity_message" ;
    public static final Integer RecordAudioRequestCode = 1;
    private SpeechRecognizer speechRecognizer;
    Intent intent;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consciousness);
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
                Log.d("ConsciousnessActivity", bestResult);
                if(bestResult.equals("Tak") || bestResult.equals("TAK") || bestResult.equals("tak"))
                {
                    switch_to_conscious_activity(view);
                }
                else if(bestResult.equals("Nie") || bestResult.equals("nie") || bestResult.equals("NIE"))
                {
                    switch_to_unconscious_activity(view);
                }

            }

            @Override
            public void onPartialResults(Bundle bundle) {
                ArrayList<String> data = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                String bestResult = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION).get(0);
                Log.d("ConsciousnessActivity", bestResult);
                if(bestResult.equals("Tak") || bestResult.equals("TAK") || bestResult.equals("tak"))
                {
                    switch_to_conscious_activity(view);
                }
                else if(bestResult.equals("Nie") || bestResult.equals("nie") || bestResult.equals("NIE"))
                {
                    switch_to_unconscious_activity(view);
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
        intent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_MINIMUM_LENGTH_MILLIS, Long.valueOf(10000));
        //intent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_POSSIBLY_COMPLETE_SILENCE_LENGTH_MILLIS, Long.valueOf(100));

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
        speechRecognizer.destroy();
        speechRecognizer = null;
        Intent intent = new Intent(this, ConsciousActivity.class);
        String consciousness_activity_message ="consciousness_activity_message";
        intent.putExtra(CONSCIOUSNESS_ACTIVITY_MESSAGE, consciousness_activity_message);
        startActivity(intent);
        this.finish();
    }

    public void launchUnconsciousActivity(View view)
    {
        speechRecognizer.destroy();
        speechRecognizer = null;
        Intent intent = new Intent(this, UnconsciousActivity.class);
        String consciousness_activity_message ="consciousness_activity_message";
        intent.putExtra(CONSCIOUSNESS_ACTIVITY_MESSAGE, consciousness_activity_message);
        startActivity(intent);
        this.finish();
    }
}