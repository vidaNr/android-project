package com.example.pinterest;

import static com.example.pinterest.Constant.API_KEY;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;


import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.pinterest.Model.Image;

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
    private int page = 1;

    private MyApi myApi;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvImages = findViewById(R.id.rv_images);
        list = new ArrayList<>();
        imageAdapter = new ImageAdapter(this, list);
        manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rvImages.setLayoutManager(manager);
        rvImages.setHasFixedSize(true);
        rvImages.setAdapter(imageAdapter);

        callApi();
    }

    private void callApi() {
        Constant.getMyApi().getImage(API_KEY, 30, 1).enqueue(new Callback<List<Image>>() {
            @Override
            public void onResponse(Call<List<Image>> call, Response<List<Image>> response) {
                if ((response.body() != null)) {

                    list.addAll(response.body());
                    imageAdapter.notifyDataSetChanged();
                    Log.d("AAA", "loading");
                }
            }
            @Override
            public void onFailure(Call<List<Image>> call, Throwable t) {
                Log.d("AAA", "Failed");
            }
        });


    }
}




