
package com.example.durma.dager2_retrofit_rx_databasemvp.mvp.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class StaffContactPhones {

    @SerializedName("home")
    private String Home;
    @SerializedName("mobile")
    private String Mobile;

    public String getHome() {
        return Home;
    }

    public void setHome(String home) {
        Home = home;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

}
