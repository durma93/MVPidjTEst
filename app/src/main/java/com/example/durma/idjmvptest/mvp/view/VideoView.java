package com.example.durma.idjmvptest.mvp.view;

import com.example.durma.idjmvptest.mvp.model.Video;

import java.util.List;

public interface VideoView extends BaseView {

    void onVideoLoaded(List<Video> cakes);
}
