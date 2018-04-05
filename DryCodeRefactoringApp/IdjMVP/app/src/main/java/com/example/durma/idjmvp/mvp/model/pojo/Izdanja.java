package com.example.durma.idjmvp.mvp.model.pojo;

/**
 * Created by durma on 1.3.18..
 */

public class Izdanja {

    private int image;
    private Izvodjaci izvodjaci;
    private String title;

    public Izdanja(int image, Izvodjaci izvodjaci, String title) {
        this.image = image;
        this.izvodjaci = izvodjaci;
        this.title = title;
    }

    public Izdanja() {
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Izvodjaci getIzvodjaci() {
        return izvodjaci;
    }

    public void setIzvodjaci(Izvodjaci izvodjaci) {
        this.izvodjaci = izvodjaci;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
