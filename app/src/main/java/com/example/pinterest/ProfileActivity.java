package com.example.pinterest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ProfileActivity extends Activity {

    Menu menu;
    private BottomNavigationView btnNav;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        btnNav = findViewById(R.id.botton_nav);
        btnNav.setSelectedItemId(R.id.ic_profile);
        checkActionBar();


    }

    private void checkActionBar() {
        btnNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_home: {
                        Toast.makeText(ProfileActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                        return true;
                    }
                    case R.id.ic_profile: {
                        return true;
                    }
                }
                return false;
            }
        });
    }


}

