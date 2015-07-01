package com.dev.chat.vdomax.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class UserManager {


    private final String KEY_PREFS = "prefs_user";
    public static final String KEY_ID = "USER_ID";

    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mEditor;


    public UserManager(Context context) {
        mPrefs = context.getSharedPreferences(KEY_PREFS, Context.MODE_PRIVATE);
        mEditor = mPrefs.edit();
        mPrefs.getInt(KEY_ID,1);
    }

    public SharedPreferences getPref() {
        return mPrefs;
    }


    public boolean checkLoginValidate(int userId) {
        int storedUserId = mPrefs.getInt(KEY_ID, 1);
        if (userId == storedUserId) {
            return true;
        }
        return false;
    }


    public boolean registerUser(int userId) {
        mEditor.putInt(KEY_ID, userId);
        return mEditor.commit();
    }
}