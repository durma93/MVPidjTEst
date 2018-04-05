package com.example.durma.idjmvptest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.durma.idjmvptest.Adapters.MainAdapter;
import com.example.durma.idjmvptest.Adapters.VideoAdapter;
import com.example.durma.idjmvptest.base.BaseActivity;
import com.example.durma.idjmvptest.di.components.DaggerMainComponent;
import com.example.durma.idjmvptest.di.module.MainModule;
import com.example.durma.idjmvptest.mvp.model.Video;
import com.example.durma.idjmvptest.mvp.presenter.MainPresenter;
import com.example.durma.idjmvptest.mvp.view.MainView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainView {

    @Inject
    protected MainPresenter mPresenter;

    @BindView(R.id.mainRecyclerView)
    RecyclerView recyclerView;

    VideoAdapter mVideoAdapter;
    MainAdapter mMainAdapter;

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);

        initializeList();
        mPresenter.getVideos();
    }

    private void initializeList() {
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mMainAdapter = new MainAdapter(getLayoutInflater());

        recyclerView.setAdapter(mMainAdapter);



    }

    @Override
    protected int getContetView() {
        return R.layout.activity_main;
    }

    @Override
    protected void resolveDaggerDependency() {
        DaggerMainComponent.builder()
                .applicationCompontent(getApplicationCompontent())
                .mainModule(new MainModule(this))
                .build().inject(this);
    }




    @Override
    public <T> void onContentLoaded(List<T> listItem) {
        mMainAdapter.addRows(listItem);
    }

    @Override
    public void onShowDialog(String message) {

    }

    @Override
    public void getHideDialog() {

    }

    @Override
    public void onShowToast(String message) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
