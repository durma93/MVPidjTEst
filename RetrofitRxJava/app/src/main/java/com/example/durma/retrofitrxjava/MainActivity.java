package com.example.durma.retrofitrxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import com.example.durma.retrofitrxjava.root.App;

import com.example.durma.retrofitrxjava.Result;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    TwichApi twichApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App)getApplication()).getComponent().inject(this);

        Call<MovieDB> call = twichApi.getTopGames("d462c65dfe2a98267053d137baf821d1");

        call.enqueue(new Callback<MovieDB>() {
            @Override
            public void onResponse(Call<MovieDB> call, Response<MovieDB> response) {
                List<Result> gameList = response.body().getResults();

                for (Result r : gameList){

                    System.out.println(r.getTitle());

                }
            }

            @Override
            public void onFailure(Call<MovieDB> call, Throwable t) {
                t.printStackTrace();
            }
        });

        twichApi.getTopGamesObservable("d462c65dfe2a98267053d137baf821d1").
                flatMap(new Func1<MovieDB, Observable<Result>>() {
            @Override
            public Observable<Result> call(MovieDB movieDB) {
                return Observable.from(movieDB.getResults());
            }

                 }).flatMap(new Func1<Result, Observable<String>>() {
            @Override
            public Observable<String> call(Result result) {
                return Observable.just(result.getOriginalTitle());
                }

                 }
                 ).filter(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return s.startsWith("S");
            }
        })

                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                Log.e("Greska", "onError: ", e);
            }

            @Override
            public void onNext(String s) {
                System.out.println("From rx java with filter:" + s);
            }
        });


        twichApi.getTopGamesObservable("d462c65dfe2a98267053d137baf821d1").
                flatMap(new Func1<MovieDB, Observable<Result>>() {
                    @Override
                    public Observable<Result> call(MovieDB movieDB) {
                        return Observable.from(movieDB.getResults());
                    }

                }).flatMap(new Func1<Result, Observable<Integer>>() {
            @Override
            public Observable<Integer> call(Result result) {
                return Observable.just(result.getVoteCount());
            }
        }).
                filter(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) {
                        return (integer >= 5000);
                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                Log.e("Greska", "onError: ", e);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("Broj promenjen" + integer);
            }
        });
    }
}
