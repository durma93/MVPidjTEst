package com.example.durma.retrofittutorijalnemac2;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by durma on 9.1.18..
 */

public interface UserClient {

    @POST("user")
    Call<User> createAccount(@Body User user);
}
