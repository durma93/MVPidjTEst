package com.example.durma.idjmvptest.mvp.presenter;

import com.example.durma.idjmvptest.base.BasePresenter;
import com.example.durma.idjmvptest.mvp.view.VideoView;
import com.example.durma.idjmvptest.repo.Baza;

import javax.inject.Inject;

public class VideoPresenter extends BasePresenter<VideoView> {

    @Inject
    public VideoPresenter() {
    }

    public void getVideos(){
        getView().onVideoLoaded(Baza.getAllVideos());
    }
}
