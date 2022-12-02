package com.example.quizapp.Model.SharedPreferences;

import java.util.ArrayList;

public class MyDB {
    private ArrayList<Score> scores = new ArrayList<>();

    public MyDB() {
    }

    public ArrayList<Score> getScores() {
        return scores;
    }

    public MyDB setScores(ArrayList<Score> scores) {
        this.scores = scores;
        return this;
    }
}
