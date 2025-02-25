package com.example.pinterest;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pinterest.Model.Image;

import java.util.ArrayList;
import java.util.List;

public abstract class ImageAdapter extends RecyclerView.Adapter<ImageViewHolder> {
    private Context context;
    private ArrayList<Image> list;
    Intent intent;

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

        holder.cvParent.setOnClickListener(view -> {

            onImageDetail(list.get(position));

            context.startActivity(intent);

        });

        holder.tvDesc.setText(list.get(position).getDescription());

        if (position == getItemCount() - 1) {
            onEndOfPage();
        }
    }

    public abstract void onEndOfPage();

    public abstract void onImageDetail(Image image);

    @Override
    public int getItemCount() {
        return list.size();
    }

}
