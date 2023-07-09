package com.example.pinterest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Constant {
    private static final String BASE_URL = "https://api.unsplash.com";
    public static final String API_KEY = "8jAE8Oiu_qSJrMJsDnjMgAb5Kd8EYH8FFwKzx2TGxG4";
    public static Retrofit retrofit = null;

    public static MyApi getMyApi() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(MyApi.class);
    }

}
