package com.example.durma.idjmvptest.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.antonyt.infiniteviewpager.InfinitePagerAdapter;
import com.example.durma.idjmvptest.R;
import com.example.durma.idjmvptest.mvp.model.Video;
import com.example.durma.idjmvptest.mvp.presenter.MainPresenter;
import com.example.durma.idjmvptest.mvp.view.VideoView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> implements VideoView {


    protected List rows;

    @Inject
    protected Context mContext;

    private LayoutInflater mLayoutInflater;
    private VideoAdapter mVideoAdapter;

    public MainAdapter(LayoutInflater mLayoutInflater) {
        this.mLayoutInflater = mLayoutInflater;
    }

    private final int SLIDER_MODE = 0;
    private final int TAB_MODE = 1;
    private final int SPOTS_MODE = 2;
    private final int CLIPS_MODE = 3;
    private final int EMISIJE_MODE = 4;
    private final int IZDANJA_MODE = 5;
    private final int PLAYLIST_MODE = 6;
    private final int IZVODJACI_MODE = 7;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        switch(viewType) {
            case SLIDER_MODE:
                view = inflater.inflate(R.layout.recyclerview_first_3, parent, false);
                break;
            case TAB_MODE:
                view = inflater.inflate(R.layout.recyclerview_first_3, parent, false);
                break;
            case SPOTS_MODE:
                view = inflater.inflate(R.layout.recyclerview_first_3, parent, false);
                break;
            case CLIPS_MODE:
                view = inflater.inflate(R.layout.recyclerview_first_3, parent, false);
                break;
            case EMISIJE_MODE:
                view = inflater.inflate(R.layout.recyclerview_first_3, parent, false);
                break;
            case IZDANJA_MODE:
                view = inflater.inflate(R.layout.recyclerview_first_3, parent, false);
                break;
            case PLAYLIST_MODE:
                view = inflater.inflate(R.layout.recyclerview_first_3, parent, false);
                break;
            case IZVODJACI_MODE:
                view = inflater.inflate(R.layout.recyclerview_first_3, parent, false);
                break;
            default:
                view = inflater.inflate(R.layout.recyclerview_first_3, parent, false);
        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        /*if (holder.getItemViewType() == SLIDER_MODE) {
            ViewPager viewPager = (ViewPager) holder.itemView.findViewById(R.id.infiniteScrool);

            PagerAdapter wrapperAdapter = new InfinitePagerAdapter(adapter);
            viewPager.setAdapter(wrapperAdapter);

        }
        else if (holder.getItemViewType() == TAB_MODE){

            TabLayout tabLayout = (TabLayout) holder.itemView.findViewById(R.id.tabLayout);
            ViewPager viewPager = (ViewPager) holder.itemView.findViewById(R.id.videoContent);
            TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(context);
            tabPagerAdapter.addTab(R.layout.tab_card_content,"NAJNOVIJI");
            tabPagerAdapter.addTab(R.layout.tab_card_content2,"NAJGLEDANIJI");
            viewPager.setAdapter(tabPagerAdapter);
            viewPager.setFocusable(false);
            tabLayout.setupWithViewPager(viewPager);

        }
        else if (holder.getItemViewType() == SPOTS_MODE) {
            linearLayout = (LinearLayout)holder.itemView.findViewById(R.id.seeMore);
            linearLayout.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, SeeMoreActivity.class);
                    i.putExtra("headTitle", "SPOTOVI");
                    context.startActivity(i);
                }
            });


            TextView title = (TextView) holder.itemView.findViewById(R.id.headTitle);
            title.setText("SPOTOVI");
            String name = title.getText().toString();
            RecyclerViewAdapterSpotovi recyclerViewAdapterSpotovi = new RecyclerViewAdapterSpotovi(context, Lists.getAllSpotovi(), name);

            holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            holder.recyclerView.setAdapter(recyclerViewAdapterSpotovi);
        }
        else if (holder.getItemViewType() == CLIPS_MODE) {

            linearLayout = (LinearLayout)holder.itemView.findViewById(R.id.seeMore);

            linearLayout.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, SeeMoreActivity.class);
                    i.putExtra("headTitle", "IDJKLIPS");
                    context.startActivity(i);
                }
            });

            TextView title = (TextView) holder.itemView.findViewById(R.id.headTitle);
            title.setText("IDJKLIPS");
            String name = title.getText().toString();
            RecyclerViewAdapterIDJClips recyclerViewAdapterIDJClips = new RecyclerViewAdapterIDJClips(context, Lists.getAllClips(), name);
            holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            holder.recyclerView.setAdapter(recyclerViewAdapterIDJClips);
        }
        else if (holder.getItemViewType() == EMISIJE_MODE) {

            linearLayout = (LinearLayout)holder.itemView.findViewById(R.id.seeMore);

            linearLayout.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, SeeMoreActivity.class);
                    i.putExtra("headTitle", "EMISIJE");
                    context.startActivity(i);
                }
            });

            TextView title = (TextView) holder.itemView.findViewById(R.id.headTitle);
            title.setText("EMISIJE");
            String name = title.getText().toString();
            RecyclerViewAdapterEmisije recyclerViewAdapterEmisije = new RecyclerViewAdapterEmisije(context, Lists.getAllEmisije(), name);
            holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            holder.recyclerView.setAdapter(recyclerViewAdapterEmisije);
        }

        else if (holder.getItemViewType() == IZDANJA_MODE) {

            linearLayout = (LinearLayout)holder.itemView.findViewById(R.id.seeMore);

            linearLayout.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, SeeMoreActivity.class);
                    i.putExtra("headTitle", "IZDANJA");
                    context.startActivity(i);
                }
            });

            TextView title = (TextView) holder.itemView.findViewById(R.id.headTitle);
            title.setText("IZDANJA");
            String name = title.getText().toString();

            RecyclerViewAdapterIzdanja recyclerViewAdapterIzdanja = new RecyclerViewAdapterIzdanja(context, Lists.getAllIzdanja(), name);
            holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            holder.recyclerView.setAdapter(recyclerViewAdapterIzdanja);
        }
        else if (holder.getItemViewType() == PLAYLIST_MODE) {

            linearLayout = (LinearLayout)holder.itemView.findViewById(R.id.seeMore);

            linearLayout.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, SeeMoreActivity.class);
                    i.putExtra("headTitle", "PLAYLIST");
                    context.startActivity(i);
                }
            });

            TextView title = (TextView) holder.itemView.findViewById(R.id.headTitle);
            title.setText("PLAYLIST");
            String name = title.getText().toString();

            RecyclerViewAdapterPlaylist recyclerViewAdapterPlaylist = new RecyclerViewAdapterPlaylist(context, Lists.getAllPlaylist(), name);
            holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            holder.recyclerView.setAdapter(recyclerViewAdapterPlaylist);
        }
        else if (holder.getItemViewType() == IZVODJACI_MODE) {

            linearLayout = (LinearLayout)holder.itemView.findViewById(R.id.seeMore);

            linearLayout.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, SeeMoreActivity.class);
                    i.putExtra("headTitle", "IZVODJACI");
                    context.startActivity(i);
                }
            });

            TextView title = (TextView) holder.itemView.findViewById(R.id.headTitle);
            title.setText("IZVODJACI");
            String name = title.getText().toString();

            RecyclerViewAdapterIzvodjaci recyclerViewAdapterIzvodjaci = new RecyclerViewAdapterIzvodjaci(context, Lists.getAllIzvodjaci(), name);
            holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            holder.recyclerView.setAdapter(recyclerViewAdapterIzvodjaci);
        }*/
    }

    @Override
    public int getItemCount() {
        return rows.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public <T> void addRows(List<T> row){
        rows.addAll(row);
        notifyDataSetChanged();

    }

    @Override
    public void onVideoLoaded(List<Video> videos) {
        mVideoAdapter.addVideos(videos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private Context mContext;
        @BindView(R.id.recyclerViewcontainer)
        RecyclerView recyclerView;

        public ViewHolder(View itemView) {
            super(itemView);

            mContext = itemView.getContext();
            ButterKnife.bind(this,itemView);
        }
    }
}
