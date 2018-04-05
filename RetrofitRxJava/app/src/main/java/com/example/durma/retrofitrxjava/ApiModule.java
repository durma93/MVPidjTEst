package com.example.durma.retrofitrxjava;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by durma on 12.3.18..
 */
@Module
public class ApiModule {

    private final String BASEURL="https://api.themoviedb.org/3/movie/";

    @Provides
    public OkHttpClient provideClient(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);

        return new OkHttpClient.Builder().addInterceptor(interceptor).build();

    }


    @Provides
    public Retrofit provideRetrofit(String baseURL, OkHttpClient client){

        return new Retrofit.Builder().
                baseUrl(baseURL).
                client(client).
                addConverterFactory(GsonConverterFactory.create()).
                addCallAdapterFactory(RxJavaCallAdapterFactory.create()).
                build();

    }

    @Provides
    public TwichApi provideApiService(){

        return provideRetrofit(BASEURL,provideClient()).create(TwichApi.class);

    }
}
