package com.example.pinterest;

import static com.example.pinterest.Constant.API_KEY;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.pinterest.Model.Image;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity {

    private RecyclerView rvImages;
    private ImageAdapter imageAdapter;
    private ArrayList<Image> list;
    private StaggeredGridLayoutManager manager;
    private int imagePage = 1;
    private int pageSize = 30;
    private MyApi myApi;

    private BottomNavigationView btnNav;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNav = findViewById(R.id.botton_nav);
        btnNav.setSelectedItemId(R.id.ic_home);
        btnNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_home: {
                        return true;
                    }
                    case R.id.ic_profile: {
                        Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        finish();
                        return true;
                    }
                }
                return false;
            }

        });

        init();
        fetchImage();

    }

    private void init() {

        rvImages = findViewById(R.id.rv_images);
        list = new ArrayList<>();

        Log.d("aaa", "this?");
        manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rvImages.setLayoutManager(manager);
        rvImages.setHasFixedSize(true);
        rvImages.setAdapter(imageAdapter);

    }

    private void fetchImage() {
        Constant.getMyApi().getImage(API_KEY, 30, imagePage).enqueue(new Callback<List<Image>>() {
            @Override
            public void onResponse(Call<List<Image>> call, Response<List<Image>> response) {
                if ((response.body() != null)) {

                    if (imageAdapter == null) {

                        imageAdapter = new ImageAdapter(MainActivity.this, list) {

                            @Override
                            public void onEndOfPage() {

                                imagePage++;
                                Log.d("aaa", "count of pageImage " + imagePage);
                                fetchImage();
                            }
                        };
                        rvImages.setAdapter(imageAdapter);
                        list.addAll(response.body());
                    } else {
                        imageAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Image>> call, Throwable t) {

            }
        });
    }

}




