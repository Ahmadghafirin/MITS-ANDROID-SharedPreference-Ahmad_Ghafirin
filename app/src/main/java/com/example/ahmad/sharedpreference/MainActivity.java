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
    private EditText etName, etAddress, etNoHp, etEmail;

    public static final String TAG = "TagMainActivity";
    public static final String KEY_NAME = "name";
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_NO_HP = "nohp";
    public static final String KEY_EMAIL = "email";
    public static final String PREFERENCE_NAME = "sharedpreference";
    public static final String KEY_INFO = "info";
    public static final String ISLOGGEDIN = "isloggedin";

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean(ISLOGGEDIN, false);
        Log.d("isloggedin", String.valueOf(isLoggedIn));
        if (isLoggedIn) openHome();
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate is called");

        etName = (EditText) findViewById(R.id.et_name);
        etAddress = (EditText) findViewById(R.id.et_address);
        etNoHp = (EditText) findViewById(R.id.et_no_hp);
        etEmail = (EditText) findViewById(R.id.et_email);

    }

    public void goRegister(View view) {
        String nama = etName.getText().toString();
        String address = etAddress.getText().toString();
        String noHp = etNoHp.getText().toString();
        String email = etEmail.getText().toString();

        if (nama.isEmpty()) {
            etName.setError("Name must be filled!");
            etName.requestFocus();
            return;

        } else if (address.isEmpty()) {
            etAddress.setError("Address must be filled!");
            etAddress.requestFocus();
            return;
        } else if (noHp.isEmpty()) {
            etNoHp.setError("Phone Number must be filled!");
            etNoHp.requestFocus();
            return;

        } else if (email.isEmpty()) {
            etEmail.setError("Email must be filled!");
            etEmail.requestFocus();
            return;

        } else {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_NAME, nama);
            editor.putString(KEY_ADDRESS, address);
            editor.putString(KEY_NO_HP, noHp);
            editor.putString(KEY_EMAIL, email);
            editor.putBoolean(ISLOGGEDIN, true);
            editor.apply();
            openHome();
        }

    }

    private void openHome() {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }
}
