package com.example.pinterest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApi {

    @GET("getImages")
    Call<List<GetImagesResponse>> getImages();

}
