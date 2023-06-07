package com.example.pinterest;

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
