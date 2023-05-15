package com.example.newsapp.repository;

import androidx.lifecycle.LiveData;

import com.example.newsapp.model.storyList;

public interface NewsRepository {
    public LiveData<storyList> getNews();
}
