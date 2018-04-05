package com.example.durma.retrofitrxjava;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by durma on 12.3.18..
 */

public interface TwichApi {

    @GET("top_rated")
    Call<MovieDB> getTopGames(@Query("api_key") String api_key);

    @GET("top_rated")
    Observable<MovieDB> getTopGamesObservable(@Query("api_key") String api_key);
}
