package com.example.pinterest;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


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


        Button btnSignIn = findViewById(R.id.btn_sign_in);
        btnSignIn.setOnClickListener(view -> {


            if ((ietEmail.getText().toString().isEmpty())) {
                Toast.makeText(this, "Email is required!", Toast.LENGTH_SHORT).show();
            } else if ((ietPass.getText().toString().isEmpty())) {
                Toast.makeText(this, "Password is required!", Toast.LENGTH_SHORT).show();
            }

            validation();

        });
    }

    private void validation() {

        String email = "example@example.com";
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$\n";

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            // Email is valid
            Toast.makeText(LoginActivity.this , "Email is valid",Toast.LENGTH_SHORT).show();
            goMain();

        } else {
            // Email is invalid
            Toast.makeText(LoginActivity.this , "Email is invalid",Toast.LENGTH_SHORT).show();
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



