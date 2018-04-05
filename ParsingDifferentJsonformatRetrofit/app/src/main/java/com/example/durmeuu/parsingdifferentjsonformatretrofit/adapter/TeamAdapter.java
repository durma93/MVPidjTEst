package com.example.durmeuu.parsingdifferentjsonformatretrofit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.durmeuu.parsingdifferentjsonformatretrofit.Model.Team;
import com.example.durmeuu.parsingdifferentjsonformatretrofit.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Durmeuu on 12/22/17.
 */

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {

    private Context context;

    private List<Team> teams = new ArrayList<>();

    public TeamAdapter(Context applicationContext, List<Team> teams) {
        this.context = applicationContext;
        this.teams = teams;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.teams_card, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Team team = teams.get(position);
        holder.textView.setText(team.getTitle());
        String tumnail = team.getUrl();

        Glide.with(context).load(tumnail).into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        return teams.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView)itemView.findViewById(R.id.thumbnail);
            textView = (TextView)itemView.findViewById(R.id.titlees);
        }
    }
}
