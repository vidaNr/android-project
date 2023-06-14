package com.example.pinterest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;


public class UnsplashApiClient {

    private static final String BASE_URL = "https://api.unsplash.com";
    private static final String ACCESS_KEY = "xLMvQGeU-fEdbFwrVySOOsrl_Vbxjq2W6hD5P88WeXI";

    private static UnsplashApiService apiService;

    public static UnsplashApiService getApiService() {
        if (apiService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiService = retrofit.create(UnsplashApiService.class);
        }
        return apiService;
    }

    public interface UnsplashApiService {
        @GET("photos/random")
        Call<GetImagesResponse> getRandomPhoto(
                @Query("8jAE8Oiu_qSJrMJsDnjMgAb5Kd8EYH8FFwKzx2TGxG4") String accessKey,
                @Query("query") String query,
                @Query("orientation") String orientation
        );

    }


}
