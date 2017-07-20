package com.example.ahmad.sharedpreference;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.attr.password;
import static android.content.Context.MODE_PRIVATE;

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
