package com.example.durma.idjmvp.mvp.view;

import com.example.durma.idjmvp.mvp.model.pojo.Emisije;
import com.example.durma.idjmvp.mvp.model.pojo.IDJClips;
import com.example.durma.idjmvp.mvp.model.pojo.Izdanja;
import com.example.durma.idjmvp.mvp.model.pojo.Izvodjaci;
import com.example.durma.idjmvp.mvp.model.pojo.Playlist;
import com.example.durma.idjmvp.mvp.model.pojo.Video;

import java.util.List;

public interface MainView extends BaseView {

    void onEmisijieLoaded(List<Emisije> clips);
    void onClipsLoaded(List<IDJClips> clips);
    void onIzdanjaLoaded(List<Izdanja> clips);
    void onIzvodjaciLoaded(List<Izvodjaci> clips);
    void onPlaylistLoaded(List<Playlist> clips);
    void onVideosLoaded(List<Video> videos);
}
