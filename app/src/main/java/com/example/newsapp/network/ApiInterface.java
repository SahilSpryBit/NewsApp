package com.example.newsapp.network;

import com.example.newsapp.model.storyList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ApiInterface {

    @GET("news/v1/index")
    Call<storyList> getNews(@Header("X-RapidAPI-Key") String apiKey);



}

