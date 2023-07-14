package com.example.pinterest;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ImageViewHolder extends RecyclerView.ViewHolder {
    public ImageView ivImage;
    public CardView cvParent;
    public TextView tvDesc;

    public ImageViewHolder(@NonNull View itemView) {
        super(itemView);
        ivImage = itemView.findViewById(R.id.iv_image);
        cvParent = itemView.findViewById(R.id.cv_parent);
        tvDesc = itemView.findViewById(R.id.tv_description);

    }
}
