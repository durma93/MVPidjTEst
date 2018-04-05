package com.example.durma.idjmvp.mvp.model.pojo;

/**
 * Created by durma on 1.3.18..
 */

public class Playlist {

    private int image;
    private String title;

    public Playlist(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Playlist() {
    }
}
