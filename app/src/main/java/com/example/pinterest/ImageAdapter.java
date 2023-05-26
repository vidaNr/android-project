package com.example.pinterest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImageAdapter extends RecyclerView.Adapter<ImageViewHolder> {
    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image,parent,false);

        ImageViewHolder viewHolder = new ImageViewHolder(itemView) ;


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
    holder.ivImage.setImageResource(R.drawable.);
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
