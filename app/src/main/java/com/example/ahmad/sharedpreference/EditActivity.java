package com.example.ahmad.sharedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private EditText etEditName, etEditAddress, etEditNoHp, etEditEmail;
    private String name, address, noHp, email;
    public static final int RESULT_EDIT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        sharedPreferences = getSharedPreferences(MainActivity.PREFERENCE_NAME, MODE_PRIVATE);

        etEditName = (EditText) findViewById(R.id.et_edit_name);
        etEditAddress = (EditText) findViewById(R.id.et_edit_address);
        etEditNoHp = (EditText) findViewById(R.id.et_edit_nohp);
        etEditEmail = (EditText) findViewById(R.id.et_edit_email);

        name = sharedPreferences.getString(MainActivity.KEY_NAME, "");
        address = sharedPreferences.getString(MainActivity.KEY_ADDRESS, "");
        noHp = sharedPreferences.getString(MainActivity.KEY_NO_HP, "");
        email = sharedPreferences.getString(MainActivity.KEY_EMAIL, "");

        etEditName.setText(name);
        etEditAddress.setText(address);
        etEditNoHp.setText(noHp);
        etEditEmail.setText(email);
    }

    public void submitSaveEdit(View view) {
        String editName, editAddress, editNoHp, editEmail;
        editName = etEditName.getText().toString();
        editAddress = etEditAddress.getText().toString();
        editNoHp = etEditNoHp.getText().toString();
        editEmail = etEditEmail.getText().toString();

        Intent intent = new Intent();
        intent.putExtra(MainActivity.KEY_NAME, editName);
        intent.putExtra(MainActivity.KEY_ADDRESS, editAddress);
        intent.putExtra(MainActivity.KEY_NO_HP, editNoHp);
        intent.putExtra(MainActivity.KEY_EMAIL, editEmail);
        setResult(RESULT_EDIT, intent);
        finish();
    }
}
