package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.google.android.material.button.MaterialButton;

import java.util.Objects;

public class Menu extends AppCompatActivity {

    private MaterialButton menu_BTN_startGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Remove blue header
        Objects.requireNonNull(getSupportActionBar()).hide();

        // Generate all widgets
        findViews();

        // All Buttons
        buttons();

    }

    private void buttons() {
        menu_BTN_startGame.setOnClickListener(v -> changeScreenToGame());
    }

    private void findViews() {
        menu_BTN_startGame = findViewById(R.id.menu_BTN_startGame);
    }

    private void changeScreenToGame() {
        Intent gameIntent = new Intent(this, GameActivity.class);
        startActivity(gameIntent);
        finish();
    }

}