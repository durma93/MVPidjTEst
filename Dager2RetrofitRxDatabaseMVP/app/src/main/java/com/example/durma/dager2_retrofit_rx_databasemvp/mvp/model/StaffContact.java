
package com.example.durma.dager2_retrofit_rx_databasemvp.mvp.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class StaffContact {

    @SerializedName("dateOfBirth")
    private String DateOfBirth;
    @SerializedName("email")
    private List<String> Email;
    @SerializedName("id")
    private Long Id;
    @SerializedName("name")
    private String Name;
    @SerializedName("phones")
    private StaffContactPhones StaffContactPhones;
    @SerializedName("role")
    private String Role;

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public List<String> getEmail() {
        return Email;
    }

    public void setEmail(List<String> email) {
        Email = email;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public StaffContactPhones getStaffContactPhones() {
        return StaffContactPhones;
    }

    public void setStaffContactPhones(StaffContactPhones staffContactPhones) {
        StaffContactPhones = staffContactPhones;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

}
