package com.example.durma.idjmvp.mvp.presenter;

import com.example.durma.idjmvp.base.BasePresenter;

import com.example.durma.idjmvp.mvp.model.list.Lists;
import com.example.durma.idjmvp.mvp.view.MainView;

import javax.inject.Inject;

public class MainPresenter extends BasePresenter<MainView> {

    @Inject
    public MainPresenter() {
    }

    public void getEmisije(){
        getView().onEmisijieLoaded(Lists.getAllEmisije());
    }

    public void getClips(){
        getView().onClipsLoaded(Lists.getAllClips());
    }

    public void getIzdanja(){
        getView().onIzdanjaLoaded(Lists.getAllIzdanja());
    }

    public void getIzvodjaci(){
        getView().onIzvodjaciLoaded(Lists.getAllIzvodjaci());
    }

    public void getPlaylist(){
        getView().onPlaylistLoaded(Lists.getAllPlaylist());
    }

    public void getVideos(){
        getView().onVideosLoaded(Lists.getAllVideos());
    }


}
