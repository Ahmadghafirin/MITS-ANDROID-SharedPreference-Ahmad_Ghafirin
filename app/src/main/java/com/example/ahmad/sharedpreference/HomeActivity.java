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
    private String name, address, noHp, email;
    private TextView tvUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sharedPreferences = getSharedPreferences(MainActivity.PREFERENCE_NAME, MODE_PRIVATE);

        name = sharedPreferences.getString(MainActivity.KEY_NAME, "");
        address = sharedPreferences.getString(MainActivity.KEY_ADDRESS, "");
        noHp = sharedPreferences.getString(MainActivity.KEY_NO_HP, "");
        email = sharedPreferences.getString(MainActivity.KEY_EMAIL, "");

        tvUser = (TextView) findViewById(R.id.tv_info);

        tvUser.setText(result());
    }

    public void goLogout(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public void goEdit(View view) {
        Intent intent = new Intent(this, EditActivity.class);
        startActivityForResult(intent, EditActivity.RESULT_EDIT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String name, address, noHp, email;
        if (resultCode == EditActivity.RESULT_EDIT) {

            name = data.getStringExtra(MainActivity.KEY_NAME);
            address = data.getStringExtra(MainActivity.KEY_ADDRESS);
            noHp = data.getStringExtra(MainActivity.KEY_NO_HP);
            email = data.getStringExtra(MainActivity.KEY_EMAIL);

            tvUser.setText(result());

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(MainActivity.KEY_NAME, name);
            editor.putString(MainActivity.KEY_ADDRESS, address);
            editor.putString(MainActivity.KEY_NO_HP, noHp);
            editor.putString(MainActivity.KEY_EMAIL, email);
            editor.apply();
        }
    }

    public String result() {
        return "Hello my Name is :" + name + "\nmy Address is at :" + address +
                "\nmy Phone Number is :" + noHp + "\nmy Email is :" + email;
    }
}
