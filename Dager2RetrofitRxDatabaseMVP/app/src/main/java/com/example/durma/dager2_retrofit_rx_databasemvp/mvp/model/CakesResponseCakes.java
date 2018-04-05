
package com.example.durma.dager2_retrofit_rx_databasemvp.mvp.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CakesResponseCakes {

    @SerializedName("detailDescription")
    private String DetailDescription;
    @SerializedName("id")
    private int Id;
    @SerializedName("image")
    private String Image;
    @SerializedName("previewDescription")
    private String PreviewDescription;
    @SerializedName("title")
    private String Title;

    public String getDetailDescription() {
        return DetailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        DetailDescription = detailDescription;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getPreviewDescription() {
        return PreviewDescription;
    }

    public void setPreviewDescription(String previewDescription) {
        PreviewDescription = previewDescription;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

}
