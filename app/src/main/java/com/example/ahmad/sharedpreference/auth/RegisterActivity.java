package com.example.ahmad.sharedpreference.auth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.ahmad.sharedpreference.model.User;
import com.example.ahmad.sharedpreference.R;
import com.example.ahmad.sharedpreference.utility.DataBaseHandler;
import com.example.ahmad.sharedpreference.utility.SessionManager;

public class RegisterActivity extends AppCompatActivity {

    private final String TAG = RegisterActivity.class.getSimpleName();
    private EditText etName, etAddress, etNoHp, etEmail, etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = (EditText) findViewById(R.id.et_name);
        etAddress = (EditText) findViewById(R.id.et_address);
        etNoHp = (EditText) findViewById(R.id.et_no_hp);
        etEmail = (EditText) findViewById(R.id.et_email);
        etPass = (EditText) findViewById(R.id.et_pass);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    public void goRegister(View view) {
        String nama = etName.getText().toString();
        String address = etAddress.getText().toString();
        String noHp = etNoHp.getText().toString();
        String email = etEmail.getText().toString();
        String pass = etPass.getText().toString();

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
            DataBaseHandler baseHandler = DataBaseHandler.getInstance();

            User user = new User(nama, address, noHp, email, pass);
            if (user != null) {
                /*SessionManager.getInstance().setPerson(user);
                */
                baseHandler.addUser(user);
                for (User user1 : baseHandler.getAllUser()) {
                    Log.d(TAG, "Data : " + user1.toString());
                }
            }
        }
    }
}
