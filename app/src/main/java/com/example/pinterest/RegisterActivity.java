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

import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends Activity {

    boolean showPassword = false;
    boolean showRePassword = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextInputEditText etPassword = findViewById(R.id.iet_show_pass_1);

        Button btnRegister = findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(v -> {

            startActivity(new Intent(RegisterActivity.this, FavoritesActivity.class));


        });


    }
}
