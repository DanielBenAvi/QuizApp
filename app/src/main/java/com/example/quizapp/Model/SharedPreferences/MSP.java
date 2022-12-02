package com.example.quizapp.Model.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

public class MSP {
    private static final String SP_FILE = "SharedPrefsExampleApp";
    private SharedPreferences sp;

    // singleton
    private static MSP msp;

    private MSP(@NonNull Context context) {
        sp = context.getApplicationContext().getSharedPreferences(SP_FILE, Context.MODE_PRIVATE); // MODE_PRIVATE - only this app can read the data
    }

    public static MSP getInstance(@NonNull Context context) {
        if (msp == null) {
            msp = new MSP(context);
        }
        return msp;
    }

    /**
     * save string to shared preferences
     *
     * @param key   the key of the value
     * @param value the value to save
     */
    public void putString(String key, String value) {
        SharedPreferences.Editor editor = sp.edit();// get the editor

        // put the data
        editor.putString(key, value);
        editor.apply();
    }

    /**
     * get string from shared preferences
     *
     * @param key          the key of the value
     * @param defaultValue the default value to return if the key is not found
     * @return the value
     */
    public String getString(String key, String defaultValue) {
        return sp.getString(key, defaultValue);
    }
}
