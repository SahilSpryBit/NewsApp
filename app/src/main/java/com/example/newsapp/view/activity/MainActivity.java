package com.example.newsapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.newsapp.view.adapter.News_Adapter;
import com.example.newsapp.R;
import com.example.newsapp.model.storyList;
import com.example.newsapp.viewmodel.News_ViewModel;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    News_Adapter newsAdapter;
    News_ViewModel news_viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.news_recycler);

        news_viewModel = new ViewModelProvider(this).get(News_ViewModel.class);
        newsAdapter = new News_Adapter(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(newsAdapter);

        news_viewModel.getNews().observe(this, new Observer<storyList>() {
            @Override
            public void onChanged(storyList storyList) {

                newsAdapter.setNews(storyList.getStoryList());
            }
        });


    }
}