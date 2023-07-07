package com.example.pinterest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class RegisterActivity extends Activity {

    boolean showPassword=false;
    boolean showRePassword=false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        ImageView ivShowPassword = findViewById(R.id.iv_show_password);
        EditText etPassword = findViewById(R.id.et_password);
        ivShowPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivShowPassword.setImageResource(showPassword ? R.drawable.ic_eye_on : R.drawable.ic_eye_off);
                etPassword.setInputType(showPassword ? InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD : InputType.TYPE_CLASS_TEXT);

                showPassword = !showPassword;

            }
        });


        ImageView ivShowRePassword = findViewById(R.id.iv_show_re_password);
        EditText etRePassword = findViewById(R.id.et_re_password);
        ivShowRePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivShowRePassword.setImageResource(showRePassword ? R.drawable.ic_eye_on : R.drawable.ic_eye_off);
                etRePassword.setInputType(showRePassword ? InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD : InputType.TYPE_CLASS_TEXT);

                showRePassword = !showRePassword;
            }
        });


        Button btnRegister = findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(v -> {
            startActivity(new Intent(RegisterActivity.this, FavoritesActivity.class));
            finish();

        });


    }
}
