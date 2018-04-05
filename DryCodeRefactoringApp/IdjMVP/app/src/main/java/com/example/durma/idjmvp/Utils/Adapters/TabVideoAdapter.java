package com.example.durma.idjmvp.Utils.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.durma.idjmvp.R;
import com.example.durma.idjmvp.Utils.PlayVideo.PlayVideoActivity;
import com.example.durma.idjmvp.mvp.model.pojo.Video;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ivandjordjevic on 27.2.18..
 */

public class TabVideoAdapter extends RecyclerView.Adapter<TabVideoAdapter.TabVideoViewHolder> {
    private Context context;
    private ArrayList<Video> videos;
    private String headTitle;

    public TabVideoAdapter(Context context, ArrayList<Video> videos, String headTitle) {
        this.context = context;
        this.videos = videos;
        this.headTitle = headTitle;
    }

    @Override
    public TabVideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_item, parent, false);

        return new TabVideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TabVideoViewHolder holder, int position) {
        Picasso.with(context)
                .load(videos.get(position).getSlika()).resize(200,100)
                .into(holder.image);
        holder.name.setText(videos.get(position).getNaziv());
        holder.views.setText(videos.get(position).getBroj_pregleda());


    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public class TabVideoViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name, views;

        public TabVideoViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.image);
            name = (TextView) itemView.findViewById(R.id.name);
            views = (TextView) itemView.findViewById(R.id.views);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION){

                        Video getVideo = videos.get(pos);

                        Intent i = new Intent(context, PlayVideoActivity.class);
                        i.putExtra("videos", getVideo);
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(i);
                        Toast.makeText(view.getContext(), "Kliknuli smo: " +getVideo.getNaziv(), Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }

    }

}
