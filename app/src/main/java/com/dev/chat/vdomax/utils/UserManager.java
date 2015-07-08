package com.dev.chat.vdomax.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class UserManager {

    private final String KEY_PREFS = "prefs_user";
    public static final String USER_ID = "USER_ID";

    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mEditor;


    public UserManager(Context context) {
        mPrefs = context.getSharedPreferences(KEY_PREFS, Context.MODE_PRIVATE);
        mEditor = mPrefs.edit();

    }

    public SharedPreferences getPref() {
        return mPrefs;
    }

    public boolean registerUser(int userId) {
        mEditor.putInt(USER_ID, userId);
        return mEditor.commit();
    }

    public int getUserId() {
        return mPrefs.getInt(USER_ID,1);
    }
}