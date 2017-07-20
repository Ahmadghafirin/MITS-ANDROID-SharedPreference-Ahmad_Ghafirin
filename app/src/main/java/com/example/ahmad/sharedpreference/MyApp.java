package com.example.ahmad.sharedpreference;

import android.app.Application;

/**
 * Created by ahmad on 19/07/17.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SessionManager.init(this);
    }
}
