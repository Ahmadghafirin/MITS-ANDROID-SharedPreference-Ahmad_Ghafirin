package com.example.ahmad.sharedpreference;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.ahmad.sharedpreference.MainActivity.KEY_ADDRESS;
import static com.example.ahmad.sharedpreference.MainActivity.KEY_EMAIL;
import static com.example.ahmad.sharedpreference.MainActivity.KEY_INFO;
import static com.example.ahmad.sharedpreference.MainActivity.KEY_NAME;
import static com.example.ahmad.sharedpreference.MainActivity.KEY_NO_HP;

public class HomeActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sharedPreferences = getSharedPreferences(MainActivity.PREFERENCE_NAME, MODE_PRIVATE);
    }

    private Person getPerson() {
        Person person = new Person(sharedPreferences.getString(KEY_NAME, ""),
                sharedPreferences.getString(KEY_ADDRESS, ""),
                sharedPreferences.getInt(KEY_NO_HP, 0), sharedPreferences.getString(KEY_EMAIL, ""));
        return person;
    }

    public void goInfo(View view) {
        AlertDialog.Builder dialogInfo = new AlertDialog.Builder(HomeActivity.this);
        dialogInfo
                .setTitle("Info Person")
                .setMessage(getPerson().info())
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog dialog = dialogInfo.create();
        dialog.show();
    }
}
