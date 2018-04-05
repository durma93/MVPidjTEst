package com.example.durma.idjmvp.Utils.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.durma.idjmvp.R;
import com.example.durma.idjmvp.mvp.model.list.Lists;

import java.util.ArrayList;

/**
 * Created by ivandjordjevic on 7.12.17..
 */

public class tTabPagerAdapter extends PagerAdapter {

    private LayoutInflater inflater;
    private Context context;

    private ArrayList<Integer> layouts = new ArrayList<>();
    private ArrayList<String> titles = new ArrayList<>();

    public TabPagerAdapter(Context context) {
        this.context = context;
    }

    public void addTab(int layout, String title) {
        layouts.add(layout);
        titles.add(title);
    }

    @Override
    public int getCount() {
        return layouts.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view;
        TabVideoAdapter adapter;

        RecyclerView recyclerView;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //inflater = LayoutInflater.from(context); // context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        switch (layouts.get(position)) {
            case R.layout.tab_card_content:
                view = inflater.inflate(R.layout.tab_card_content, container, false);
                adapter = new TabVideoAdapter(view.getContext(), Lists.getAllVideos(), null);
                recyclerView = (RecyclerView) view.findViewById(R.id.videoContent);
                recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
                recyclerView.setAdapter(adapter);
                recyclerView.setFocusable(false);
                container.addView(view);
                break;
            case R.layout.tab_card_content2:
                view = inflater.inflate(R.layout.tab_card_content2, container, false);
                adapter = new TabVideoAdapter(view.getContext(), Lists.getAllVideos2(), null);
                recyclerView = (RecyclerView) view.findViewById(R.id.videoContent);
                recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
                recyclerView.setAdapter(adapter);
                recyclerView.setFocusable(false);

                container.addView(view);
                break;

            default:
                view = inflater.inflate(R.layout.tab_card_content, container, false);
                adapter = new TabVideoAdapter(view.getContext(), Lists.getAllVideos2(), null);
                recyclerView = (RecyclerView) view.findViewById(R.id.videoContent);
                recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
                recyclerView.setAdapter(adapter);
                recyclerView.setFocusable(false);
                container.addView(view);
        }
        return view;
    }



    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
