package com.example.pinterest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;


import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity {

    private static final String API_KEY = "8jAE8Oiu_qSJrMJsDnjMgAb5Kd8EYH8FFwKzx2TGxG4";
    private RecyclerView rvImages;
    private ImageAdapter imageAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        callApi();


//
//        String jsonString = "{\n" +
//                "    \"id\": \"ckfXPMb2_BI\",\n" +
//                "    \"slug\": \"ckfXPMb2_BI\",\n" +
//                "    \"created_at\": \"2023-04-28T12:46:16Z\",\n" +
//                "    \"updated_at\": \"2023-06-05T01:34:45Z\",\n" +
//                "    \"promoted_at\": \"2023-05-28T14:40:01Z\",\n" +
//                "    \"width\": 8256,\n" +
//                "    \"height\": 5504,\n" +
//                "    \"color\": \"#262626\",\n" +
//                "    \"blur_hash\": \"LA8qBD=dQRx]KQe.v|oz5mELR%bv\",\n" +
//                "    \"description\": \"The remote NEOM desert environment sets the scene for spectacular stargazing, Hisma Desert – NEOM, Saudi Arabia.\",\n" +
//                "    \"alt_description\": \"a man standing next to a tent in the desert\",\n" +
//                "    \"urls\": {\n" +
//                "        \"raw\": \"https://images.unsplash.com/photo-1682685797769-481b48222adf?ixid=M3w0NTM1NjN8MHwxfHJhbmRvbXx8fHx8fHx8fDE2ODU5NTYzNDR8&ixlib=rb-4.0.3\",\n" +
//                "        \"full\": \"https://images.unsplash.com/photo-1682685797769-481b48222adf?crop=entropy&cs=srgb&fm=jpg&ixid=M3w0NTM1NjN8MHwxfHJhbmRvbXx8fHx8fHx8fDE2ODU5NTYzNDR8&ixlib=rb-4.0.3&q=85\",\n" +
//                "        \"regular\": \"https://images.unsplash.com/photo-1682685797769-481b48222adf?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w0NTM1NjN8MHwxfHJhbmRvbXx8fHx8fHx8fDE2ODU5NTYzNDR8&ixlib=rb-4.0.3&q=80&w=1080\",\n" +
//                "        \"small\": \"https://images.unsplash.com/photo-1682685797769-481b48222adf?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w0NTM1NjN8MHwxfHJhbmRvbXx8fHx8fHx8fDE2ODU5NTYzNDR8&ixlib=rb-4.0.3&q=80&w=400\",\n" +
//                "        \"thumb\": \"https://images.unsplash.com/photo-1682685797769-481b48222adf?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w0NTM1NjN8MHwxfHJhbmRvbXx8fHx8fHx8fDE2ODU5NTYzNDR8&ixlib=rb-4.0.3&q=80&w=200\",\n" +
//                "        \"small_s3\": \"https://s3.us-west-2.amazonaws.com/images.unsplash.com/small/photo-1682685797769-481b48222adf\"\n" +
//                "    },\n" +
//                "    \"links\": {\n" +
//                "        \"self\": \"https://api.unsplash.com/photos/ckfXPMb2_BI\",\n" +
//                "        \"html\": \"https://unsplash.com/photos/ckfXPMb2_BI\",\n" +
//                "        \"download\": \"https://unsplash.com/photos/ckfXPMb2_BI/download?ixid=M3w0NTM1NjN8MHwxfHJhbmRvbXx8fHx8fHx8fDE2ODU5NTYzNDR8\",\n" +
//                "        \"download_location\": \"https://api.unsplash.com/photos/ckfXPMb2_BI/download?ixid=M3w0NTM1NjN8MHwxfHJhbmRvbXx8fHx8fHx8fDE2ODU5NTYzNDR8\"\n" +
//                "    }\n" +
//                "}";
//
//
//        try {
//            JSONObject jsonObject = new JSONObject(jsonString);
//
//
//        } catch (JSONException e) {
//            throw new RuntimeException(e);
//        }


//        List<Image> imageList = new ArrayList<>();
//        imageList.add(new Image(1, "make up", "beauty", 200, 300, "https://images.unsplash.com/photo-1490818387583-1baba5e638af?ixlib=rb-4.0.3"));
//        imageList.add(new Image(3, "make up", "beauty", 200, 300, "https://images.unsplash.com/photo-1490818387583-1baba5e638af?ixlib=rb-4.0.3"));
//        imageList.add(new Image(2, "garden", "design", 200, 300, "https://images.unsplash.com/photo-1682809463394-b464a18a02ad?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w0NTM1NjN8MHwxfHJhbmRvbXx8fHx8fHx8fDE2ODUwODg1Mzl8&ixlib=rb-4.0.3&q=80&w=1080"));


    }


    private void callApi() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.unsplash.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MyApi unsplashApi = retrofit.create(MyApi.class);
        unsplashApi.getRandomPhotos("8jAE8Oiu_qSJrMJsDnjMgAb5Kd8EYH8FFwKzx2TGxG4").enqueue(new Callback<List<GetImagesResponse>>() {
            @Override
            public void onResponse(Call<List<GetImagesResponse>> call, Response<List<GetImagesResponse>> response) {
                // Handle successful response here
                Log.d("AAA","hgjgiu");
                List<GetImagesResponse> photos = response.body();
                RecyclerView rvImages = findViewById(R.id.rv_images);
                rvImages.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                ImageAdapter adapter = new ImageAdapter(photos);
                rvImages.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<GetImagesResponse>> call, Throwable t) {
                // Handle failure here
            }
        });


    }


}
