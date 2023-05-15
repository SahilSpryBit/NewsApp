package com.example.newsapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.newsapp.repository.News_Repository;
import com.example.newsapp.model.storyList;

public class News_ViewModel extends ViewModel {

    private News_Repository news_repository;

    public News_ViewModel(){

        news_repository = new News_Repository();
    }

    public LiveData<storyList> getNews(){
        return news_repository.getNews();
    }
}
