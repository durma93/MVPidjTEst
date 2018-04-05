package com.example.durma.idjmvptest.mvp.view;


import com.example.durma.idjmvptest.mvp.model.Video;

import java.util.List;

public interface MainView extends BaseView {

    //void onVideoLoaded(List<Video> cakes);

    <T> void onContentLoaded(List<T> listItem);
    void onShowDialog(String message);

    void getHideDialog();

    void onShowToast(String message);
}
