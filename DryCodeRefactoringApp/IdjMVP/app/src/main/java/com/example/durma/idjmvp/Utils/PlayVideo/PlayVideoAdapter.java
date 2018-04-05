package com.example.durma.idjmvp.Utils.PlayVideo;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.durma.idjmvp.R;
import com.example.durma.idjmvp.Utils.Adapters.RecyclerViewAdapterSpotovi;
import com.example.durma.idjmvp.mvp.model.list.Lists;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;

/**
 * Created by ivandjordjevic on 5.3.18..
 */

public class PlayVideoAdapter extends RecyclerView.Adapter<PlayVideoAdapter.PlayVideoViewHolder> {

    private final String API_KEY = "AIzaSyAhWQGJSV1-ngYulYdfwWfZMojTgkq8n74";
    private final String VIDEO_CODE = "dPI-mRFEIH0";
    private YouTubePlayerView player;


    private Context context;
    private ArrayList mod;

    private final int LIKE_SHARE_USER_MODE = 0;
    private final int KUPI_SLUSAJ_MODE = 1;
    private final int SPOTOVI_MODE = 2;
    private final int PREPORUCENO_MODE = 3;

    public PlayVideoAdapter(Context context, ArrayList mod) {
        this.context = context;
        this.mod = mod;
    }

    @Override
    public PlayVideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);

        switch (viewType) {
            case LIKE_SHARE_USER_MODE:
                view = inflater.inflate(R.layout.like_share_user, parent, false);
                break;
            case KUPI_SLUSAJ_MODE:
                view = inflater.inflate(R.layout.kupi_slusaj, parent, false);
                break;
            case SPOTOVI_MODE:
                view = inflater.inflate(R.layout.recyclerview_first_3, parent, false);
                break;
            case PREPORUCENO_MODE:
                view = inflater.inflate(R.layout.recyclerview_first_3, parent, false);
                break;
            default:
                view = inflater.inflate(R.layout.video, parent, false);
        }
        return new PlayVideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PlayVideoViewHolder holder, int position) {
        if(holder.getItemViewType() == LIKE_SHARE_USER_MODE) {

        } else if(holder.getItemViewType() == KUPI_SLUSAJ_MODE) {

        } else if(holder.getItemViewType() == SPOTOVI_MODE) {
            TextView title = (TextView) holder.itemView.findViewById(R.id.headTitle);
            title.setText("SPOTOVI");
            RecyclerView recyclerView = holder.itemView.findViewById(R.id.recyclerViewcontainer);
            recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            recyclerView.setHasFixedSize(true);
            RecyclerViewAdapterSpotovi adapter = new RecyclerViewAdapterSpotovi(context, Lists.getAllVideos(), "");
            recyclerView.setAdapter(adapter);
            recyclerView.setFocusable(false);
        } else if(holder.getItemViewType() == PREPORUCENO_MODE) {
            TextView title = (TextView) holder.itemView.findViewById(R.id.headTitle);
            title.setText("PREPORUČENO");
            RecyclerView recyclerView = holder.itemView.findViewById(R.id.recyclerViewcontainer);
            recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            recyclerView.setHasFixedSize(true);
            RecyclerViewAdapterSpotovi adapter = new RecyclerViewAdapterSpotovi(context, Lists.getAllVideos2(), "");
            recyclerView.setAdapter(adapter);
            recyclerView.setFocusable(false);
        }
    }

    @Override
    public int getItemCount() {
        return mod.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class PlayVideoViewHolder extends RecyclerView.ViewHolder {

        public PlayVideoViewHolder(View itemView) {
            super(itemView);
        }

    }

}
