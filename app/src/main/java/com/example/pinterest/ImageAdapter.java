package com.example.pinterest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pinterest.Model.Image;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageViewHolder> {

    private Context context;
    private ArrayList<Image> list;

    public ImageAdapter(Context context, ArrayList<Image> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.item_image, parent, false);

        ImageViewHolder viewHolder = new ImageViewHolder(itemView);



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {


        Glide.with(context)
                .load(list.get(position).getUrls().getRegular())
                .into(holder.ivImage);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
