package com.example.durma.idjmvp.mvp.model.pojo;

/**
 * Created by durma on 1.3.18..
 */

public class Izvodjaci {

    private int image;
    private String fullName;

    public Izvodjaci(int image, String fullName) {
        this.image = image;
        this.fullName = fullName;
    }

    public Izvodjaci() {
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
