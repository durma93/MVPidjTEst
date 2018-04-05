package com.example.durma.idjmvptest.mvp.presenter;


import com.example.durma.idjmvptest.base.BasePresenter;
import com.example.durma.idjmvptest.mvp.view.MainView;
import com.example.durma.idjmvptest.repo.Baza;

import javax.inject.Inject;

public class MainPresenter extends BasePresenter<MainView> {

    @Inject
    public MainPresenter() {
    }

   /* public void getVideos(){
        getView().onVideoLoaded(Baza.getAllVideos());
    }*/

    public void getVideos(){
        getView().onContentLoaded(Baza.getRows());
    }

}
