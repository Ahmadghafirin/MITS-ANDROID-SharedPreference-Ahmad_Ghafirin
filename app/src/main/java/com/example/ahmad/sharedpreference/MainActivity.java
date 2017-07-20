package com.example.ahmad.sharedpreference;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ahmad.sharedpreference.R;
import com.example.ahmad.sharedpreference.auth.LoginActivity;
import com.example.ahmad.sharedpreference.utility.SessionManager;

public class MainActivity extends AppCompatActivity {
    private SessionManager sessionManager;
    private TextView tvUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sessionManager = SessionManager.getInstance();

        tvUser = (TextView) findViewById(R.id.tv_info);

        tvUser.setText(sessionManager.getPerson().toString());


    }

    public void goLogout(View view) {
        SessionManager.getInstance().clear();
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
