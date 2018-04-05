package com.example.durma.idjmvp.Utils.PlayVideo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.durma.idjmvp.R;
import com.example.durma.idjmvp.mvp.model.pojo.Video;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;

public class PlayVideoActivity extends YouTubeBaseActivity {

    private final String API_KEY = "AIzaSyAhWQGJSV1-ngYulYdfwWfZMojTgkq8n74";
    private YouTubePlayerView player;

    private RecyclerView recyclerView;
    private PlayVideoAdapter adapter;

    private ArrayList mod;
    Video video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);

        player = (YouTubePlayerView) findViewById(R.id.videoPlayer);
        player.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                if (!b){
                    Intent i = getIntent();
                    if (i.hasExtra("videos")){
                        video = getIntent().getParcelableExtra("videos");
                        youTubePlayer.loadVideo(video.getUrl());
                        youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);

                    }else {
                        Toast.makeText(PlayVideoActivity.this, "Nema videa", Toast.LENGTH_SHORT).show();

                    }


                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(PlayVideoActivity.this, youTubeInitializationResult.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        mod = new ArrayList();
        mod.add(new Object());
        mod.add(new Object());
        mod.add(new Object());
        mod.add(new Object());

        recyclerView = (RecyclerView) findViewById(R.id.playVideoContainer);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);

        adapter = new PlayVideoAdapter(this, mod);

        recyclerView.setAdapter(adapter);

    }

    private void getVideoPlayed(){

    }
}


