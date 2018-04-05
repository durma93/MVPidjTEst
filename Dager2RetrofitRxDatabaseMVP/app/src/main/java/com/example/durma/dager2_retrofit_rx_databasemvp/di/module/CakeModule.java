package com.example.durma.dager2_retrofit_rx_databasemvp.di.module;

import com.example.durma.dager2_retrofit_rx_databasemvp.api.CakeApiService;
import com.example.durma.dager2_retrofit_rx_databasemvp.di.scope.PerActivity;
import com.example.durma.dager2_retrofit_rx_databasemvp.mvp.view.MainView;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by durma on 13.3.18..
 */

@Module
public class CakeModule {

    private MainView mView;

    public CakeModule(MainView view){
        mView = view;
    }

    @PerActivity
    @Provides
    CakeApiService provideApiService(Retrofit retrofit){
        return retrofit.create(CakeApiService.class);
    }

    @PerActivity
    @Provides
    MainView provideView(){
        return mView;
    }

}
