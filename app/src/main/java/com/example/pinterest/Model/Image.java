package com.example.pinterest.Model;

import com.example.pinterest.Model.UrlModel;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Image implements Serializable {


    private UrlModel urls;

    public Image(UrlModel urls) {
        this.urls = urls;
    }
    public String getImage() { return imageUrl; }


    public UrlModel getUrls() {
        return urls;
    }
    public void setUrls(UrlModel urls) {
        this.urls = urls;
    }


    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String image) { this.imageUrl = image; }



    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    public Image(String id, String description, String imageUrl) {
        this.id = id;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    private String id;

    @SerializedName("alt_description")
    public String description;

    @SerializedName("regular")
    public String imageUrl;



}
