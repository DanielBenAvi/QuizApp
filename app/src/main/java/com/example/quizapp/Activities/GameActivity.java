package com.example.quizapp.Activities;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;


import com.example.quizapp.Model.GameManager;
import com.example.quizapp.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Objects;

public class GameActivity extends AppCompatActivity {

    private MaterialTextView game_TXT_score;

    private ShapeableImageView game_IMG_photo;

    private ShapeableImageView[] game_IMG_hears;

    private MaterialButton[] game_BTN_answers;

    private GameManager gameManager;

    ArrayList<String> answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Remove blue header
        Objects.requireNonNull(getSupportActionBar()).hide();

        findViews();

        gameManager = new GameManager(game_IMG_hears.length);

        updateUI();

        buttons();


    }

    private void updateUI() {
        game_TXT_score.setText(MessageFormat.format("{0}", gameManager.getScore()));

        if (gameManager.isLost()) {
            changeScreenToGame("Game Over!");
        } else if (gameManager.isGameEnded()) {
            changeScreenToGame("Winner");
        } else {
            // update image
            game_IMG_photo.setImageResource(gameManager.getCurrentFlagImg());
            // get random 4 answers
            answers = gameManager.getAnswers();
            // change the name of the buttons
            for (int i = 0; i < game_BTN_answers.length; i++) {
                game_BTN_answers[i].setText(answers.get(i));
            }
            if (gameManager.getWrong() != 0) {
                game_IMG_hears[game_IMG_hears.length - gameManager.getWrong()].setVisibility(View.INVISIBLE);
            }


        }
    }

    /**
     * activate all the button in Screen
     */
    private void buttons() {
        game_BTN_answers[0].setOnClickListener(v -> clicked(answers.get(0)));
        game_BTN_answers[1].setOnClickListener(v -> clicked(answers.get(1)));
        game_BTN_answers[2].setOnClickListener(v -> clicked(answers.get(2)));
        game_BTN_answers[3].setOnClickListener(v -> clicked(answers.get(3)));

    }


    /**
     * click on an answer
     *
     * @param answer the current answer
     */
    private void clicked(String answer) {
        String temp_name = gameManager.getCurrentName();
        gameManager.checkAnswer(answer);
        updateUI();
    }


    /**
     * Generate Views
     */
    private void findViews() {
        game_TXT_score = findViewById(R.id.game_TXT_score);

        game_IMG_photo = findViewById(R.id.game_IMG_photo);

        game_IMG_hears = new ShapeableImageView[]{
                findViewById(R.id.game_IMG_heart1),
                findViewById(R.id.game_IMG_heart2),
                findViewById(R.id.game_IMG_heart3),
        };
        game_BTN_answers = new MaterialButton[]{
                findViewById(R.id.game_BTN_ans1),
                findViewById(R.id.game_BTN_ans2),
                findViewById(R.id.game_BTN_ans3),
                findViewById(R.id.game_BTN_ans4),
        };
    }

    /**
     * change screen
     */
    private void changeScreenToGame(String status) {
        Intent endIntent = new Intent(this, EndActivity.class);
        endIntent.putExtra(EndActivity.KEY_SCORE, gameManager.getScore());
        endIntent.putExtra(EndActivity.KEY_STATUS, status);
        startActivity(endIntent);
        finish();
    }
}