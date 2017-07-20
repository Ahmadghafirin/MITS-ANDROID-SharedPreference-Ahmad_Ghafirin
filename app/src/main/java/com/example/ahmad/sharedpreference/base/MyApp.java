package com.example.ahmad.sharedpreference.base;

import android.app.Application;

import com.example.ahmad.sharedpreference.utility.DataBaseHandler;
import com.example.ahmad.sharedpreference.utility.SessionManager;

/**
 * Created by ahmad on 19/07/17.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SessionManager.init(this);
        DataBaseHandler.init(this);
    }
}
