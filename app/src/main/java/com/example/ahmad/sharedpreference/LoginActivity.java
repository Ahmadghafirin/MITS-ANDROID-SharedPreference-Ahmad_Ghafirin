package com.example.ahmad.sharedpreference;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private EditText etEmail, etPass;

    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sessionManager = SessionManager.getInstance();

        etEmail = (EditText) findViewById(R.id.et_login_email);
        etPass = (EditText) findViewById(R.id.et_login_pass);

    }

    public void goLogin(View view) {
        String email = etEmail.getText().toString();
        String pass = etPass.getText().toString();

        if (email.isEmpty()) {
            etEmail.setError("Email must be filled!");
            etEmail.requestFocus();
            return;
        }

        if (pass.isEmpty()) {
            etPass.setError("Password must be filled!");
            etPass.requestFocus();
            return;
        }

        if (etEmail.getText().toString().equalsIgnoreCase(sessionManager.getPerson().getEmail())
                && etPass.getText().toString().equalsIgnoreCase(sessionManager.getPerson().getPass()
        )) {

            sessionManager.setLogin(true);
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }
    }

    public void goRegisterPage(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}
