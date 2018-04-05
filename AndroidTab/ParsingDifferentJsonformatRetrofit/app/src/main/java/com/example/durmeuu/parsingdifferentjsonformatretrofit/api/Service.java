package com.example.durmeuu.parsingdifferentjsonformatretrofit.api;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Durmeuu on 12/22/17.
 */

public interface Service {

    @GET("/teams/teams.json")
    Call<JsonArray> readTeamArray();
}
