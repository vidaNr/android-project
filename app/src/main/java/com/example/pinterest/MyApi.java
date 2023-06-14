package com.example.pinterest;

import static com.example.pinterest.Constant.API_KEY;

import com.example.pinterest.Model.Image;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface MyApi {



    @GET("/photos")
    Call<List<Image>> getImage(
            @Query("client_id") String API_KEY,
            @Query("per_page") int perPage,
            @Query("page") int page
    );

}
