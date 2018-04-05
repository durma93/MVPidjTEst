package com.example.durma.idjmvp.mvp.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by durma on 1.3.18..
 */

public class Emisije implements Parcelable {
    private int image;
    private String title;

    public Emisije(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public Emisije() {
    }

    protected Emisije(Parcel in) {
        image = in.readInt();
        title = in.readString();
    }

    public static final Creator<Emisije> CREATOR = new Creator<Emisije>() {
        @Override
        public Emisije createFromParcel(Parcel in) {
            return new Emisije(in);
        }

        @Override
        public Emisije[] newArray(int size) {
            return new Emisije[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(image);
        parcel.writeString(title);
    }
}
