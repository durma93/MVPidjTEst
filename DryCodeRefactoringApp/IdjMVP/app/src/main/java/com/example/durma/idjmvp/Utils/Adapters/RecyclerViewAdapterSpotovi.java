package com.example.durma.idjmvp.Utils.Adapters;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.durma.idjmvp.R;
import com.example.durma.idjmvp.Utils.PlayVideo.PlayVideoActivity;
import com.example.durma.idjmvp.mvp.model.pojo.Video;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by durma on 2.3.18..
 */

public class RecyclerViewAdapterSpotovi extends RecyclerView.Adapter<RecyclerViewAdapterSpotovi.ViewHolder> {

    private Context context;
    private ArrayList<Video> videos;
    private String headTitle;



    public RecyclerViewAdapterSpotovi(Context context, ArrayList<Video> videos, String headTitle) {
        this.context = context;
        this.videos = videos;
        this.headTitle = headTitle;
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_item, parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Video video = videos.get(position);

        Picasso.with(context).
                load(video.getSlika()).
                resize(200,100).
                into(holder.image);

        holder.name.setText(video.getNaziv());
        holder.views.setText(video.getBroj_pregleda());
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name, views;
        LinearLayout linearLayout;


        public ViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.image);
            name = (TextView) itemView.findViewById(R.id.name);
            views = (TextView) itemView.findViewById(R.id.views);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.tabLayoutmain);

            int i = itemView.getResources().getColor(R.color.colorPrimary);

            linearLayout.setBackgroundColor(i);
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
