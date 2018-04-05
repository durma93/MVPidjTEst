package com.example.durma.idjmvp.Utils.Main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.durma.idjmvp.R;
import com.example.durma.idjmvp.base.BaseActivity;
import com.example.durma.idjmvp.di.components.DaggerMainComponent;
import com.example.durma.idjmvp.di.module.MainModule;
import com.example.durma.idjmvp.mvp.model.pojo.Emisije;
import com.example.durma.idjmvp.mvp.model.pojo.IDJClips;
import com.example.durma.idjmvp.mvp.model.pojo.Izdanja;
import com.example.durma.idjmvp.mvp.model.pojo.Izvodjaci;
import com.example.durma.idjmvp.mvp.model.pojo.Playlist;
import com.example.durma.idjmvp.mvp.model.pojo.Video;
import com.example.durma.idjmvp.mvp.presenter.MainPresenter;
import com.example.durma.idjmvp.mvp.view.MainView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainView {

    @Inject
    protected MainPresenter mPresenter;

    @BindView(R.id.mainRecyclerView)
    protected RecyclerView recyclerView;

    ArrayList rows;
    MainAdapter adapter;



    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);

        initializeList();


        mPresenter.getVideos();

        rows = new ArrayList();
        rows.add(new Video());
        rows.add(new Video());
        rows.add(new Video());
        rows.add(new IDJClips());
        rows.add(new Emisije());
        rows.add(new Izdanja());
        rows.add(new Playlist());
        rows.add(new Izvodjaci());

    }

    private void initializeList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        adapter = new MainAdapter(this, rows);
        recyclerView.setAdapter(adapter);
        recyclerView.setFocusable(false);
    }

    @Override
    protected int getContetView() {
        return R.layout.activity_main;
    }

    @Override
    protected void resolveDaggerDependency() {
        DaggerMainComponent.builder().
                applicationCompontent(getApplicationCompontent()).
                mainModule(new MainModule(this))
                .build().inject(this);
    }

    @Override
    public void onEmisijieLoaded(List<Emisije> clips) {

    }

    @Override
    public void onClipsLoaded(List<IDJClips> clips) {

    }

    @Override
    public void onIzdanjaLoaded(List<Izdanja> clips) {

    }

    @Override
    public void onIzvodjaciLoaded(List<Izvodjaci> clips) {

    }

    @Override
    public void onPlaylistLoaded(List<Playlist> clips) {

    }

    @Override
    public void onVideosLoaded(List<Video> videos) {
        recyclerView.add(videos);
    }
}
