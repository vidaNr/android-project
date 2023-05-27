package com.example.pinterest;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;

public class splashActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        SharedPreferences pref = getSharedPreferences("pinterest", MODE_PRIVATE);
        boolean isLogin = pref.getBoolean("is_login", false);


        Intent intent;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        if (!isLogin) {
            goLogin();
        } else {
            goMain();
        }

    }


    private void goLogin() {

        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        };
        handler.postDelayed(runnable, 1000);
    }

    private void goMain() {

        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {


                Intent intent = new Intent(splashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
        handler.postDelayed(runnable, 1000);
    }
}

