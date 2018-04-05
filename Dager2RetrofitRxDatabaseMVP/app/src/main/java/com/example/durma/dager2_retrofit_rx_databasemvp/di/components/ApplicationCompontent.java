package com.example.durma.dager2_retrofit_rx_databasemvp.di.components;


import android.content.Context;

import com.example.durma.dager2_retrofit_rx_databasemvp.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by durma on 13.3.18..
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationCompontent {

    Retrofit exposeRetrofit();

    Context exposeContext();
}
