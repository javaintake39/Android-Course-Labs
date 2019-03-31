package com.example.retrofitdemo.Model.network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface jsonPlaceholderService {

    @GET("posts")
    Call<ResponseBody> getPosts();

}
