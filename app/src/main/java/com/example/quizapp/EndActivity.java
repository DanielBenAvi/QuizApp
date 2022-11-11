package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import java.text.MessageFormat;
import java.util.Objects;

public class EndActivity extends AppCompatActivity {

    public static final String KEY_SCORE = "KEY_SCORE";
    public static final String KEY_STATUS = "KEY_STATUS";

    MaterialTextView end_TXT_text;
    MaterialButton end_BTN_restart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);


        // Remove blue header
        Objects.requireNonNull(getSupportActionBar()).hide();

        // buttons
        end_TXT_text = findViewById(R.id.end_TXT_text);
        end_BTN_restart = findViewById(R.id.end_BTN_restart);


        end_BTN_restart.setOnClickListener(v -> changeScreenToGame());

        Intent previousIntent = getIntent();
        String status = previousIntent.getStringExtra(KEY_STATUS);
        int score = previousIntent.getIntExtra(KEY_SCORE, 0);
        end_TXT_text.setText(MessageFormat.format("{0}\nScore: {1}", status, score));

    }

    private void changeScreenToGame() {
        Intent gameIntent = new Intent(this, GameActivity.class);
        startActivity(gameIntent);
        finish();
    }
}