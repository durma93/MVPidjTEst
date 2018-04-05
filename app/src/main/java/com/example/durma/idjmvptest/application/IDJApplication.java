package com.example.durma.idjmvptest.application;

import android.app.Application;


import com.example.durma.idjmvptest.di.components.ApplicationCompontent;
import com.example.durma.idjmvptest.di.components.DaggerApplicationCompontent;
import com.example.durma.idjmvptest.di.module.ApplicationModule;

public class IDJApplication extends Application {

    private ApplicationCompontent mApplicationCompontent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeApplicationComponent();
    }

    private void initializeApplicationComponent() {
        mApplicationCompontent = DaggerApplicationCompontent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public ApplicationCompontent getmApplicationCompontent() {
        return mApplicationCompontent;
    }
}
