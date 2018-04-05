package com.example.durma.dager2_retrofit_rx_databasemvp.application;

import android.app.Application;

import com.example.durma.dager2_retrofit_rx_databasemvp.di.components.ApplicationCompontent;
import com.example.durma.dager2_retrofit_rx_databasemvp.di.components.DaggerApplicationCompontent;
import com.example.durma.dager2_retrofit_rx_databasemvp.di.module.ApplicationModule;

/**
 * Created by durma on 13.3.18..
 */

public class CakeApplication extends Application {

    private ApplicationCompontent mApplicationCompontent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeApplicationComponent();
    }

    private void initializeApplicationComponent() {
         mApplicationCompontent = DaggerApplicationCompontent.builder()
                 .applicationModule(new ApplicationModule("https://gist.githubusercontent.com", this))
                 .build();
    }

    public ApplicationCompontent getApplicationCompontent() {
        return mApplicationCompontent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
