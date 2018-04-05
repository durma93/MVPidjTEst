package com.example.durma.idjmvptest.di.module;


import com.example.durma.idjmvptest.di.scope.PerActivity;
import com.example.durma.idjmvptest.mvp.view.MainView;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private MainView mView;

    public MainModule(MainView view) {
        mView = view;
    }


    @PerActivity
    @Provides
    MainView provideView(){
        return mView;
    }
}
