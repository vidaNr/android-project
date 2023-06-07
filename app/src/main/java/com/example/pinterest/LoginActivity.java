package com.example.pinterest;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputEditText;


public class LoginActivity extends Activity {

    boolean ShowPass = false;
    private TextInputEditText ietEmail;
    private TextInputEditText ietPass;
    Pattern pattern;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        ietEmail = findViewById(R.id.iet_email);
        ietPass = findViewById(R.id.iet_show_pass);


        String email = ietEmail.getText().toString().trim();
        String pass = ietPass.getText().toString().trim();


        Button btnSignIn = findViewById(R.id.btn_sign_in);
        btnSignIn.setOnClickListener(view -> {


            validation(email, pass);
            goMain();


        });
    }

    private void validation(String email, String pass) {

        if (email.length()==0){
            ietEmail.requestFocus();
            ietEmail.setError("It's Empty");
        }
        else if (!email.matches("[a-zA-Z0-9._-]+@[a-z]+\\\\.+[a-z]+")) {
            ietEmail.requestFocus();
            ietEmail.setError("It's not Valid");

        } else if (pass.length() < 8) {
            ietPass.requestFocus();
            ietPass.setError("Must be longer");

        } else {
            return;
        }
    }


    private void goMain() {

        SharedPreferences pref = getSharedPreferences("pinterest", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("is_login", true);
        editor.apply();

        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();

    }

}



