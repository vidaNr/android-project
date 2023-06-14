package com.example.pinterest;

import com.example.pinterest.Model.Image;

import java.util.List;

public class GetImagesResponse {


    private List<Image> image;

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }
}
