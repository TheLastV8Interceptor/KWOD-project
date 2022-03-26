package com.kwod.firstaidkwod.ui.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.kwod.firstaidkwod.R;
import com.kwod.firstaidkwod.ui.example.mvp.ExampleMVP;
import com.kwod.firstaidkwod.ui.example.mvp.ExampleModel;
import com.kwod.firstaidkwod.ui.example.mvp.ExamplePresenter;
import com.kwod.firstaidkwod.ui.main.MainActivity;

public class ExampleActivity extends AppCompatActivity implements ExampleMVP.View {

    private ExamplePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        presenter = new ExamplePresenter(this, new ExampleModel());

        presenter.doSomething();
        presenter.analyzeSpeech("tak");

    }

    @Override
    public void onDataCorrect() {
        Toast.makeText(this, "Dobre dane!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataIncorrect() {
        Toast.makeText(this, "Złe dane!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMessageYes() {

    }

    @Override
    public void onMessageNo() {

    }

    @Override
    public void onMessageUnrecognized() {

    }
}