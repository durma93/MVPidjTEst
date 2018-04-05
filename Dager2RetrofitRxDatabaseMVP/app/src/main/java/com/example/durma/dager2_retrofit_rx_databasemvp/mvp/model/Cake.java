package com.example.durma.dager2_retrofit_rx_databasemvp.mvp.model;

/**
 * Created by durma on 19.3.18..
 */

public class Cake {

    private int id;
    private String title;
    private String previewDescription;
    private String detailDescription;
    private String imageURLl;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPreviewDescription() {
        return previewDescription;
    }

    public void setPreviewDescription(String previewDescription) {
        this.previewDescription = previewDescription;
    }

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    public String getImageURLl() {
        return imageURLl;
    }

    public void setImageURLl(String imageURLl) {
        this.imageURLl = imageURLl;
    }
}
