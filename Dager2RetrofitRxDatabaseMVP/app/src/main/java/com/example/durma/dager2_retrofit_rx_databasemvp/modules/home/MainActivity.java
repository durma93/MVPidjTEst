package com.example.durma.dager2_retrofit_rx_databasemvp.modules.home;

import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.durma.dager2_retrofit_rx_databasemvp.R;
import com.example.durma.dager2_retrofit_rx_databasemvp.base.BaseActivity;
import com.example.durma.dager2_retrofit_rx_databasemvp.di.components.DaggerCakeCompontnet;
import com.example.durma.dager2_retrofit_rx_databasemvp.di.module.CakeModule;
import com.example.durma.dager2_retrofit_rx_databasemvp.modules.home.adapter.CakeAdapter;
import com.example.durma.dager2_retrofit_rx_databasemvp.mvp.model.Cake;
import com.example.durma.dager2_retrofit_rx_databasemvp.mvp.presenter.CakePresenter;
import com.example.durma.dager2_retrofit_rx_databasemvp.mvp.view.MainView;

import java.util.List;

import javax.inject.Inject;


import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainView{

    @Inject protected CakePresenter mPresenter;

    @BindView(R.id.cakeList) protected RecyclerView mCakeList;

    private CakeAdapter mCakeAdapter;

    
    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);

        initializeList();
        mPresenter.getCakes();
    }

    private void initializeList() {
        mCakeList.setHasFixedSize(true);
        mCakeList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        mCakeAdapter = new CakeAdapter(getLayoutInflater());
        mCakeList.setAdapter(mCakeAdapter);
    }

    @Override
    protected int getContetView() {
        return R.layout.activity_main;
    }

    @Override
    protected void resolveDaggerDependency() {
        DaggerCakeCompontnet.builder().
                applicationCompontent(getApplicationCompontent()).
                cakeModule(new CakeModule(this))
                .build().inject(this);
    }

    @Override
    public void onCakeLoaded(List<Cake> cakes) {
        mCakeAdapter.addCakes(cakes);
    }

    @Override
    public void onShowDialog(String message) {
        showProgressDialog(message);
    }

    @Override
    public void getHideDialog() {
        hideDialog();
    }

    @Override
    public void onShowToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}


