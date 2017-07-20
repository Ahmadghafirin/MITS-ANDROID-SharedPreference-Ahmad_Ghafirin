package com.example.ahmad.sharedpreference;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        splashScreen();
    }

    private void splashScreen() {
        Thread timer = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (SessionManager.getInstance().isLogin()) {
                        startActivity(new Intent(SplashScreenActivity.this, HomeActivity.class));
                        finish();
                    } else {
                        startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
                        finish();
                    }
                }
            }
        });
        timer.start();
    }
}
