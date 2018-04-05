package com.example.durma.mediumretrofitmvprxjavaexample.ui;

import android.util.Log;

import com.example.durma.mediumretrofitmvprxjavaexample.model.MovieResponse;
import com.example.durma.mediumretrofitmvprxjavaexample.network.RetrofitClient;
import com.example.durma.mediumretrofitmvprxjavaexample.network.RetrofitService;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements MainPresenterInterface {

    MainViewInterface mainViewInterface;
    private String TAG = "MainPresenter";

    public MainPresenter(MainViewInterface mainViewInterface) {
        this.mainViewInterface = mainViewInterface;
    }

    @Override
    public void getMovies() {
       getObservable().subscribeWith(getObserver());
    }

    public Observable<MovieResponse> getObservable (){
        return RetrofitClient.getRetrofit().create(RetrofitService.class).
                getMovies("d462c65dfe2a98267053d137baf821d1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<MovieResponse> getObserver(){
        return new DisposableObserver<MovieResponse>() {
            @Override
            public void onNext(MovieResponse movieResponse) {
                Log.d(TAG, "onNext: " +movieResponse.getTotalResults());
                mainViewInterface.displayMovies(movieResponse);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG,"Error"+e);
                e.printStackTrace();
                mainViewInterface.displayError("Error fetching Movie Data");
            }

            @Override
            public void onComplete() {
                Log.d(TAG,"Completed");
            }
        };
    }
}
