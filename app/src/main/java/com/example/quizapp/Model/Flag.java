package com.example.quizapp.Model;

public class Flag {
    private int imageRes;
    private String name;


    /**
     * Empty constructor
     */
    public Flag() {

    }

    public int getImageRes() {
        return imageRes;
    }

    public String getName() {
        return name;
    }

    public Flag setImageRes(int imageRes) {
        this.imageRes = imageRes;
        return this;
    }

    public Flag setName(String name) {
        this.name = name;
        return this;
    }
}


