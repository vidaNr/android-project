package com.example.pinterest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MyApi {

    @GET("/photos/random")
    Call<List<GetImagesResponse>> getRandomPhotos(@Query("client_id") String clientId);

}
