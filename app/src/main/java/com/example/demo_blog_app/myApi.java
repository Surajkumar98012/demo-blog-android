package com.example.demo_blog_app;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

public interface myApi {
    @GET("blogsList")
    Call<blogWrapper> getblogs();
}
