package com.example.ahmad.sharedpreference;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.attr.password;
import static android.content.Context.MODE_PRIVATE;

public class MainActivity extends AppCompatActivity {
    private EditText etName, etAddress, etNoHp, etEmail;

    public static final String KEY_NAME = "name";
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_NO_HP = "nohp";
    public static final String KEY_EMAIL = "email";
    public static final String PREFERENCE_NAME = "sharedpreference";
    public static final String KEY_INFO = "info";

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);

        etName = (EditText) findViewById(R.id.et_name);
        etAddress = (EditText) findViewById(R.id.et_address);
        etNoHp = (EditText) findViewById(R.id.et_no_hp);
        etEmail = (EditText) findViewById(R.id.et_email);

        TextView tvResult = (TextView) findViewById(R.id.tv_result);

        Person person = new Person(sharedPreferences.getString(KEY_NAME, ""),
                sharedPreferences.getString(KEY_ADDRESS, ""),
                sharedPreferences.getInt(KEY_NO_HP, 0), sharedPreferences.getString(KEY_EMAIL, ""));
        tvResult.setText(person.info());
    }

    private void setPerson(Person person) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_NAME, person.getName());
        editor.putString(KEY_ADDRESS, person.getAddress());
        editor.putInt(KEY_NO_HP, person.getNoHp());
        editor.putString(KEY_EMAIL, person.getEmail());
        editor.commit();
    }


    public void goHome(View view) {
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
            Person person = new Person(nama, address, Integer.valueOf(noHp), email);
            setPerson(person);

            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
        }

    }
}
