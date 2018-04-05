package com.example.durma.idjmvp.di.module;

import com.example.durma.idjmvp.Utils.Main.MainActivity;
import com.example.durma.idjmvp.di.scope.PerActivity;
import com.example.durma.idjmvp.mvp.model.list.Lists;
import com.example.durma.idjmvp.mvp.view.MainView;

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
