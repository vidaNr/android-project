package com.example.pinterest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;

public class splashActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);





        Handler handler =new Handler();
        Runnable runnable= new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(splashActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        };

        handler.postDelayed(runnable, 1000);

    }
}
