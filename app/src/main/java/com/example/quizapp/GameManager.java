package com.example.quizapp;

import java.util.ArrayList;
import java.util.Collections;

public class GameManager {
    private int score = 0;
    private int index;
    private int wrong = 0;
    private int life;

    ArrayList<Flag> flags;
    ArrayList<Integer> played;

    /**
     * game manager constructor
     *
     * @param life how much life the player have = 3
     */
    public GameManager(int life) {
        this.life = life;
        flags = DataManager.getFlags();
        index = getRandomNumber(flags.size());
        played = new ArrayList<Integer>();
        played.add(index);
    }

    /**
     * get the current score
     *
     * @return int
     */
    public int getScore() {
        return score;
    }

    /**
     * get the current flag
     *
     * @return Flag
     */
    private Flag current() {
        return flags.get(index);
    }

    /**
     * get the flag of the current image
     *
     * @return int
     */
    public int getCurrentFlagImg() {
        return current().getImageRes();
    }

    /**
     * gets the name of the current flags
     *
     * @return String
     */
    public String getCurrentName() {
        return current().getName();
    }

    /**
     * get the number of the current
     *
     * @return the number of wrong answer
     */
    public int getWrong() {
        return wrong;
    }

    /**
     * check if game ended
     *
     * @return boolean
     */
    public boolean isGameEnded() {
        return index == flags.size();
    }

    /**
     * check if we lost the game
     *
     * @return boolean
     */
    public boolean isLost() {
        return life == wrong;
    }

    /**
     * check if the answer is right:
     * yes -> +10 points
     * no -> +1 wrong
     * and the next question is set
     *
     * @param answer the current answer
     * @return the current answer
     */
    public void checkAnswer(String answer) {
        if (getCurrentName().equals(answer)) {
            score += 10;
        } else {
            wrong++;
        }
        newIndex();
    }


    /**
     * generate a new index
     * the index will be different than the past indexes
     */
    private void newIndex() {
        played.add(index);

        boolean flag = false;
        while (!flag) {
            int temp_index = getRandomNumber(flags.size());
            if (!played.contains(temp_index)) {
                index = temp_index;
                flag = true;
            }
        }
//        index++;
    }

    /**
     * generate 3 random answers and add theme to the current one
     *
     * @return 4 random answers
     */
    public ArrayList<String> getAnswers() {
        ArrayList<String> answers = new ArrayList<>();

        answers.add(getCurrentName());

        int temp_number = 0;
        while (temp_number < 3) {
            int randomNum = getRandomNumber(flags.size());
            if (randomNum != index) {
                answers.add(flags.get(randomNum).getName());
                temp_number++;
            }
        }

        Collections.shuffle(answers);


        return answers;
    }

    /**
     * get random number
     *
     * @param max num of flags
     * @return random int
     */
    private int getRandomNumber(int max) {
        return (int) ((Math.random() * max));
    }
}
