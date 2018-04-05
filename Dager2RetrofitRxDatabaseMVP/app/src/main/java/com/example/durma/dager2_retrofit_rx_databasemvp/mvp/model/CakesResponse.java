
package com.example.durma.dager2_retrofit_rx_databasemvp.mvp.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CakesResponse {

    @SerializedName("cakes")
    private List<CakesResponseCakes> cakesResponseCakes;
    @SerializedName("product")
    private String Product;
    @SerializedName("releaseDate")
    private String ReleaseDate;
    @SerializedName("staffContacts")
    private List<StaffContact> StaffContacts;
    @SerializedName("version")
    private Double Version;

    public List<CakesResponseCakes> getCakesResponseCakes() {
        return cakesResponseCakes;
    }

    public void setCakesResponseCakes(List<CakesResponseCakes> cakesResponseCakes) {
        this.cakesResponseCakes = cakesResponseCakes;
    }

    public String getProduct() {
        return Product;
    }

    public void setProduct(String product) {
        Product = product;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        ReleaseDate = releaseDate;
    }

    public List<StaffContact> getStaffContacts() {
        return StaffContacts;
    }

    public void setStaffContacts(List<StaffContact> staffContacts) {
        StaffContacts = staffContacts;
    }

    public Double getVersion() {
        return Version;
    }

    public void setVersion(Double version) {
        Version = version;
    }

}
