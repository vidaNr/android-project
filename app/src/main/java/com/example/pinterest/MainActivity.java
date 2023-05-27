package com.example.pinterest;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       RecyclerView rvImages = findViewById(R.id.rv_images);
       rvImages.setLayoutManager(new StaggeredGridLayoutManager(2 , StaggeredGridLayoutManager.VERTICAL));


        List<Image> imageList = new ArrayList<>();
       imageList.add(new Image(1,"make up", "beauty" , 200 ,300,"https://images.unsplash.com/photo-1490818387583-1baba5e638af?ixlib=rb-4.0.3"));
        imageList.add(new Image(3,"make up", "beauty" , 200 ,300,"https://images.unsplash.com/photo-1490818387583-1baba5e638af?ixlib=rb-4.0.3"));

        imageList.add(new Image(2,"garden", "design" , 200,300,"https://images.unsplash.com/photo-1682809463394-b464a18a02ad?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w0NTM1NjN8MHwxfHJhbmRvbXx8fHx8fHx8fDE2ODUwODg1Mzl8&ixlib=rb-4.0.3&q=80&w=1080"));



       ImageAdapter adapter = new ImageAdapter(imageList);
       rvImages.setAdapter(adapter);


    }
}
