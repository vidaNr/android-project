package com.example.pinterest.Model;

import com.example.pinterest.Model.UrlModel;
import com.google.gson.annotations.SerializedName;

public class Image {


    private UrlModel urls;

    public Image(UrlModel urls) {
        this.urls = urls;
    }

    public UrlModel getUrls() {
        return urls;
    }

    public void setUrls(UrlModel urls) {
        this.urls = urls;
    }

    public String getImageUrl() {
        return imageUrl;
    }


    private String id;
    private String title;
    private String categories;
    private int width;
    private int height;

    @SerializedName("regular")
    private String imageUrl;


    public Image(String id, String title, String categories, int width, int height, String image) {
        this.id = id;
        this.title = title;
        this.categories = categories;
        this.width = width;
        this.height = height;
        this.imageUrl = image;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getImage() {
        return imageUrl;
    }


    public void setImageUrl(String image) {
        this.imageUrl = image;
    }


}
