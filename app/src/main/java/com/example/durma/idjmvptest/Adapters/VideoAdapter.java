package com.example.durma.idjmvptest.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.durma.idjmvptest.R;
import com.example.durma.idjmvptest.mvp.model.Video;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {

    @Inject
    protected Context mContext;

    private LayoutInflater mLayoutInflater;
    private List<Video> mVideoList = new ArrayList<>();

    public VideoAdapter(LayoutInflater mLayoutInflater) {
        this.mLayoutInflater = mLayoutInflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.tab_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(mVideoList.get(position));
    }

    @Override
    public int getItemCount() {
        return mVideoList.size();
    }

    public void addVideos(List<Video> videos){
        mVideoList.addAll(videos);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private Context mContext;
        @BindView(R.id.image) protected ImageView slika;
        @BindView(R.id.name) protected TextView name;
        @BindView(R.id.views) protected TextView views;
        public ViewHolder(View itemView) {
            super(itemView);

            mContext = itemView.getContext();
            ButterKnife.bind(this,itemView);
        }

        public void bind(Video video) {
            Picasso.with(mContext)
                    .load(video.getSlika()).resize(200,100)
                    .into(slika);
            name.setText(video.getNaziv());
            views.setText(video.getBroj_pregleda());
        }
    }
}
