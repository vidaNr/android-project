package com.example.pinterest;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
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

                ivShowPass.setImageResource(!ShowPass ? R.drawable.ic_eye_off : R.drawable.ic_eye_on);
                etShowPass.setInputType(ShowPass ?InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD : InputType.TYPE_CLASS_TEXT);

                ShowPass = !ShowPass;
            }
        });
    }
}
