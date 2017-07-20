package com.example.ahmad.sharedpreference.utility;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.ahmad.sharedpreference.model.User;

/**
 * Created by ahmad on 19/07/17.
 */

public class SessionManager {

    public static final String PREFERENCE_NAME = "sharedpreference";
    public static final String KEY_NAME = "name";
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_NO_HP = "nohp";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASS = "pass";
    public static final String KEY_IS_LOGGEDIN = "isloggedin";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static SessionManager instance;

    public SessionManager(Context context) {
        int PRIVATE_MODE = 0;
        sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public static void init(Context context) {
        instance = new SessionManager(context);
    }

    public synchronized static SessionManager getInstance() {
        return instance;
    }

    public void setPerson(User user) {
        editor.putString(KEY_NAME, user.getName());
        editor.putString(KEY_ADDRESS, user.getAddress());
        editor.putString(KEY_NO_HP, user.getNoHp());
        editor.putString(KEY_EMAIL, user.getEmail());
        editor.putString(KEY_PASS, user.getPass());
        setLogin(true);
        editor.commit();
    }

    public User getPerson() {
        User user = new User(sharedPreferences.getString(KEY_NAME, ""),
                sharedPreferences.getString(KEY_ADDRESS, ""),
                sharedPreferences.getString(KEY_NO_HP, ""),
                sharedPreferences.getString(KEY_EMAIL, ""),
                sharedPreferences.getString(KEY_PASS, ""));
        return user;
    }

    public void setLogin(boolean isLogin) {
        editor.putBoolean(KEY_IS_LOGGEDIN, isLogin);
        editor.commit();
    }

    public boolean isLogin() {
        return sharedPreferences.getBoolean(KEY_IS_LOGGEDIN, false);
    }

    public void clear() {
        editor.clear();
        editor.commit();
    }
}
