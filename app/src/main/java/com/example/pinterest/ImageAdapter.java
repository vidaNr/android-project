package com.example.pinterest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageViewHolder> {

    private List<Image> imageList;

    public ImageAdapter(List<GetImagesResponse> photos) {
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);

        ImageViewHolder viewHolder = new ImageViewHolder(itemView);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {


        Glide.with(holder.itemView.getContext())
                .load(imageList.get(position).getImage())
                .into(holder.ivImage);

    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }
}
