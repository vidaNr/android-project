package com.example.pinterest;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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


        Button btnSignIn = findViewById(R.id.btn_sign_in);
        btnSignIn.setOnClickListener(view -> {

            ietEmail = findViewById(R.id.iet_email);
            ietPass = findViewById(R.id.iet_show_pass);

            if (ietEmail.getText().toString().isEmpty()) {
                ietEmail.requestFocus();
                ietEmail.setError("it's Empty");
                return;
            }
            if (!validation(ietEmail.getText().toString().trim())) {
                ietEmail.requestFocus();
                ietEmail.setError("it's Not Valid!");
                return;
            }
            if (ietPass.getText().toString().length()<8){
                ietPass.requestFocus();
                ietPass.setError("Must be longer than 8 charecter");
                return;
            }
            goMain();

        });
    }

    private boolean validation(String email) {

        pattern = Pattern.compile("(?:[A-Za-z0-9!#$%&'*+/=?.^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\\\"(?:[x01-x08x0bx0cx0e-x1fx21x23-x5bx5d-x7f]|[x01-x09x0bx0cx0e-x7f])*\\\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])).){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[x01-x08x0bx0cx0e-x1fx21-x5ax53-x7f]|[x01-x09x0bx0cx0e-x7f])+)])");

        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            return true;
        } else {
            return false;
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



