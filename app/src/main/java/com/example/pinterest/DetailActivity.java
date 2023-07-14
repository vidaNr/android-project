package com.example.pinterest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.pinterest.Model.Image;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class DetailActivity extends Activity {

    private ArrayList<Image> list;
    public Image image;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView ivDetail = findViewById(R.id.iv_image_detail);
        ImageView ivBack = findViewById(R.id.iv_back);


        image = (Image) getIntent().getExtras().get("image");
        ((TextView) findViewById(R.id.tv_description)).setText(image.getDescription());


        Glide.with(this)
                .load(image.getUrls().getRegular())
                .into(ivDetail);


        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
