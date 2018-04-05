package com.example.durma.dager2_retrofit_rx_databasemvp.di.module;

import android.content.Context;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by durma on 13.3.18..
 */

@Module
public class ApplicationModule {

    private String baseUrl;
    private Context context;

    public ApplicationModule(String baseUrl, Context context) {
        this.baseUrl = baseUrl;
        this.context = context;
    }

    @Singleton
    @Provides
    GsonConverterFactory provideGsonCoverterFactory(){
        GsonConverterFactory factory = GsonConverterFactory.create();
        return factory;
    }

    @Singleton
    @Provides
    @Named("ok-1")
    OkHttpClient provideOkHttpClient1(){
        return new OkHttpClient.Builder().
                connectTimeout(20, TimeUnit.SECONDS).
                readTimeout(20,TimeUnit.SECONDS).
                build();
    }

    @Singleton
    @Provides
    @Named("ok-2")
    OkHttpClient provideOkHttpClient2(){
        return new OkHttpClient.Builder().
                connectTimeout(60, TimeUnit.SECONDS).
                readTimeout(60,TimeUnit.SECONDS).
                build();
    }


    @Singleton
    @Provides
    Retrofit provideRetrofit(@Named("ok-1") OkHttpClient client, GsonConverterFactory converterFactory, RxJavaCallAdapterFactory adapterFactory){

        return new Retrofit.Builder().
                baseUrl(baseUrl).
                addConverterFactory(converterFactory).
                addCallAdapterFactory(adapterFactory).
                client(client).
                build();
    }

    @Singleton
    @Provides
    RxJavaCallAdapterFactory provideRxJavaCallAdapterFactory(){
        return RxJavaCallAdapterFactory.create();
    }

    @Provides
    @Singleton
    Context provideContext() {
        return this.context;
    }

}
