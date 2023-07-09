package com.example.pinterest;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImageViewHolder extends RecyclerView.ViewHolder {
    ImageView ivImage;
    public ImageViewHolder(@NonNull View itemView) {
        super(itemView);
       ivImage = itemView.findViewById(R.id.iv_image);

    }
}
