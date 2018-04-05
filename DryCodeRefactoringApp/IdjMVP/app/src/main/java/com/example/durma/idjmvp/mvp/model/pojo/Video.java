package com.example.durma.idjmvp.mvp.model.pojo;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by durma on 26.2.18..
 */

public class Video implements Parcelable {

    private int slika;
    private String naziv;
    private String broj_pregleda;
    private String url;

    public Video() {
    }

    public Video(int slika, String naziv, String broj_pregleda, String url) {
        this.slika = slika;
        this.naziv = naziv;
        this.broj_pregleda = broj_pregleda;
        this.url = url;
    }

    protected Video(Parcel in) {
        slika = in.readInt();
        naziv = in.readString();
        broj_pregleda = in.readString();
        url = in.readString();
    }

    public static final Creator<Video> CREATOR = new Creator<Video>() {
        @Override
        public Video createFromParcel(Parcel in) {
            return new Video(in);
        }

        @Override
        public Video[] newArray(int size) {
            return new Video[size];
        }
    };

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSlika() {
        return slika;
    }

    public void setSlika(int slika) {
        this.slika = slika;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getBroj_pregleda() {
        return broj_pregleda;
    }

    public void setBroj_pregleda(String broj_pregleda) {
        this.broj_pregleda = broj_pregleda;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(slika);
        parcel.writeString(naziv);
        parcel.writeString(broj_pregleda);
        parcel.writeString(url);
    }
}
