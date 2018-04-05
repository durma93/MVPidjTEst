package com.example.durma.mvpudemy.root;

import android.app.Application;

import com.example.durma.mvpudemy.login.LoginModel;
import com.example.durma.mvpudemy.login.LoginModule;

import dagger.internal.DaggerCollections;

/**
 * Created by durma on 9.3.18..
 */

public class App extends Application{
    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder().
                applicationModule(new ApplicationModule(this))
                .loginModule(new LoginModule())
                .build();
    }

    public App(ApplicationComponent component) {
        this.component = component;
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
