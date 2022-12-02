package com.example.quizapp.Model.SharedPreferences;

public class Score {
    private int score = 0;
    private String name = "";

    public Score() {
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public Score setName(String name) {
        this.name = name;
        return this;
    }

    public Score setScore(int score) {
        this.score = score;
        return this;
    }
}
