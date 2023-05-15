package com.example.newsapp.view.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.example.newsapp.Common;
import com.example.newsapp.R;
import com.example.newsapp.model.storyList;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class News_Adapter extends RecyclerView.Adapter<News_Adapter.ViewHolder> {

    Context context;
    storyList[] storyLists;

    public News_Adapter(Context context, storyList[] storyLists) {
        this.context = context;
        this.storyLists = storyLists;
    }

    public News_Adapter(Context context) {
        this.context = context;
    }

    public void setNews(storyList[] storyLists){
        this.storyLists = storyLists;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public News_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.news_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull News_Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        storyList data = storyLists[position];

        if(data.getAdDetail() != null){
            if(data.getAdDetail().getPosition() == position ){
                Log.d("Testinggg", "Ad Detailll");
                holder.main_view.setVisibility(View.GONE);
                holder.adview.setVisibility(View.VISIBLE);
                holder.main_view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "Position :: "+ position, Toast.LENGTH_SHORT).show();
                    }
                });

            }else{

                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(Long.parseLong(data.getStory().getPubTime()));
                SimpleDateFormat formatter = new SimpleDateFormat("EEE, dd MMM h:mm a");
                String formattedDate = formatter.format(calendar.getTime());

                holder.main_view.setVisibility(View.VISIBLE);
                holder.adview.setVisibility(View.GONE);
                holder.hline.setText(data.getStory().getHline());
                holder.intro.setText(data.getStory().getIntro());
                holder.time.setText(formattedDate);
                Glide.with(context).load(new GlideUrl("https://cricbuzz-cricket.p.rapidapi.com/img/v1/i1/c" + data.getStory().getImageId() + "/i.jpg", new LazyHeaders.Builder()
                        .addHeader("X-RapidAPI-Key", Common.apikey)
                        .build())).into(holder.news_image);
            }
        }
        else {
            if (data.getStory() != null) {

                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(Long.parseLong(data.getStory().getPubTime()));
                SimpleDateFormat formatter = new SimpleDateFormat("EEE, dd MMM h:mm a");
                String formattedDate = formatter.format(calendar.getTime());

                holder.main_view.setVisibility(View.VISIBLE);
                holder.adview.setVisibility(View.GONE);
                holder.hline.setText(data.getStory().getHline());
                holder.intro.setText(data.getStory().getIntro());
                holder.time.setText(formattedDate);
                Glide.with(context).load(new GlideUrl("https://cricbuzz-cricket.p.rapidapi.com/img/v1/i1/c" + data.getStory().getImageId() + "/i.jpg", new LazyHeaders.Builder()
                        .addHeader("X-RapidAPI-Key", Common.apikey)
                        .build())).into(holder.news_image);
            }
        }

        holder.main_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Position :: "+ position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return storyLists == null ? 0 : storyLists.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView hline, intro, time;
        LinearLayout main_view, adview;
        ImageView news_image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            hline = itemView.findViewById(R.id.news_txt_title);
            intro = itemView.findViewById(R.id.intro);
            main_view = itemView.findViewById(R.id.main_view);
            adview = itemView.findViewById(R.id.adview);
            news_image = itemView.findViewById(R.id.news_image);
            time = itemView.findViewById(R.id.news_txt_time);
        }
    }
}
