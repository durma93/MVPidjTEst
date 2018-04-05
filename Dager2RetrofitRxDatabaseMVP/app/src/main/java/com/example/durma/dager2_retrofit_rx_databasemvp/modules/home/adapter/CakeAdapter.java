package com.example.durma.dager2_retrofit_rx_databasemvp.modules.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.durma.dager2_retrofit_rx_databasemvp.R;
import com.example.durma.dager2_retrofit_rx_databasemvp.mvp.model.Cake;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by durma on 19.3.18..
 */

public class CakeAdapter extends RecyclerView.Adapter<CakeAdapter.Holder> {

    @Inject protected Context mContext;

    private LayoutInflater mLayoutInflater;
    private List<Cake> mListCake = new ArrayList<>();

    public CakeAdapter(LayoutInflater mLayoutInflater) {
        this.mLayoutInflater = mLayoutInflater;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.list_item_layout, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.bind(mListCake.get(position));
    }

    @Override
    public int getItemCount() {
        return mListCake.size();
    }

    public void addCakes(List<Cake> cakes){
        mListCake.addAll(cakes);
        notifyDataSetChanged();

    }

    public class Holder extends RecyclerView.ViewHolder{


        private Context mContext;
        @BindView(R.id.cake_icon) protected ImageView mCakeIcon;
        @BindView(R.id.textview_title) protected TextView mCakeTitle;
        @BindView(R.id.textview_preview_description) protected TextView mCakePreviewTitle;

        public Holder(View itemView) {
            super(itemView);

            mContext = itemView.getContext();
            ButterKnife.bind(this, itemView);

        }

        public void bind(Cake cake) {

            mCakeTitle.setText(cake.getTitle());
            mCakePreviewTitle.setText(cake.getPreviewDescription());


            Glide.with(mContext).load(cake.getImageURLl())
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(mCakeIcon);

        }
    }
}
