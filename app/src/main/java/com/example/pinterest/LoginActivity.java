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

import androidx.annotation.Nullable;

public class LoginActivity extends Activity {

    boolean ShowPass = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ImageView ivShowPass = findViewById(R.id.iv_show_pass);
        EditText etShowPass = findViewById(R.id.et_show_pass);


        ivShowPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ivShowPass.setImageResource(ShowPass ? R.drawable.ic_eye_off : R.drawable.ic_eye_on);
                etShowPass.setInputType(ShowPass ? InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD : InputType.TYPE_CLASS_TEXT);

                ShowPass = !ShowPass;
            }
        });


        Button btnSignIn = findViewById(R.id.btn_sign_in);
        btnSignIn.setOnClickListener(view -> {


            SharedPreferences pref = getSharedPreferences("pinterest", MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("is_login", true);
            editor.apply();

            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        });
    }


}


