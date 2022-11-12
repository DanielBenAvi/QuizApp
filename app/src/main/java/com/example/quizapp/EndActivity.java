package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
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
    MaterialButton end_BTN_saveScore;
    MaterialButton saveButton_BTN_save;

    private Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);


        // Remove blue header
        Objects.requireNonNull(getSupportActionBar()).hide();

        // buttons
        end_TXT_text = findViewById(R.id.end_TXT_text);
        end_BTN_restart = findViewById(R.id.end_BTN_restart);
        end_BTN_saveScore = findViewById(R.id.end_BTN_saveScore);


        end_BTN_restart.setOnClickListener(v -> changeScreenToGame());
        end_BTN_saveScore.setOnClickListener(v -> saveAction());

        Intent previousIntent = getIntent();
        String status = previousIntent.getStringExtra(KEY_STATUS);
        int score = previousIntent.getIntExtra(KEY_SCORE, 0);
        end_TXT_text.setText(MessageFormat.format("{0}\nScore: {1}", status, score));

    }

    private void saveAction() {
        // constructor
        dialog = new Dialog(this);

        // connect the dialog to the layout
        dialog.setContentView(R.layout.save_score);

        dialog.setTitle("");
        dialog.setCancelable(true);

        saveButton_BTN_save = dialog.findViewById(R.id.saveButton_BTN_save);
        saveButton_BTN_save.setOnClickListener(v -> saveButton());
        dialog.show();
    }

    private void saveButton() {
    }

    private void changeScreenToGame() {
        Intent gameIntent = new Intent(this, GameActivity.class);
        startActivity(gameIntent);
        finish();
    }
}