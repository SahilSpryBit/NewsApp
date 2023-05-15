package com.example.newsapp.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.newsapp.Common;
import com.example.newsapp.model.storyList;
import com.example.newsapp.network.ApiInterface;
import com.example.newsapp.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class News_Repository implements NewsRepository{

    private ApiInterface apiInterface;

    public News_Repository(){

        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
    }

    @Override
    public LiveData<storyList> getNews() {
        MutableLiveData<storyList> storyListMutableLiveData = new MutableLiveData<>();

        apiInterface.getNews(Common.apikey).enqueue(new Callback<storyList>() {
            @Override
            public void onResponse(Call<storyList> call, Response<storyList> response) {

                if(response.isSuccessful()){
                    storyListMutableLiveData.setValue(response.body());

                    Log.e("Sahilll", "Successs Respnse");
                }
            }

            @Override
            public void onFailure(Call<storyList> call, Throwable t) {
                Log.e("Sahilll", "Fail : No Respnse");

            }
        });

        return storyListMutableLiveData;
    }
}
