package com.example.durma.mediumretrofitmvprxjavaexample.network;

import com.example.durma.mediumretrofitmvprxjavaexample.model.MovieResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {

    @GET("discover/movie")
    Observable<MovieResponse>getMovies(@Query("api_key") String api_key);

}
