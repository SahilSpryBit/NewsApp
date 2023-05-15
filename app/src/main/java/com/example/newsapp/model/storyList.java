package com.example.newsapp.model;

import com.google.gson.annotations.SerializedName;

public class storyList {

    story story;
    adDetail adDetail;
    @SerializedName("storyList")
    storyList[] storyList;

    public com.example.newsapp.model.story getStory() {
        return story;
    }

    public void setStory(com.example.newsapp.model.story story) {
        this.story = story;
    }

    public com.example.newsapp.model.adDetail getAdDetail() {
        return adDetail;
    }

    public void setAdDetail(com.example.newsapp.model.adDetail adDetail) {
        this.adDetail = adDetail;
    }

    public com.example.newsapp.model.storyList[] getStoryList() {
        return storyList;
    }

    public void setStoryList(com.example.newsapp.model.storyList[] storyList) {
        this.storyList = storyList;
    }
}
