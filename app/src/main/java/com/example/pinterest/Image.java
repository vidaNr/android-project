package com.example.pinterest;

import com.google.gson.annotations.SerializedName;

public class Image {
    private long id;
    private String title;
    private String categories;
    private int width;
    private int height;

    @SerializedName("urls")
    private String image;


    public Image(long id, String title, String categories, int width, int height, String image) {
        this.id = id;
        this.title = title;
        this.categories = categories;
        this.width = width;
        this.height = height;
        this.image = image;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}
