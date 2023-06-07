package com.example.pinterest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetImagesResponse {

    @SerializedName("urls")
    private List<Image> image;

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }
}
