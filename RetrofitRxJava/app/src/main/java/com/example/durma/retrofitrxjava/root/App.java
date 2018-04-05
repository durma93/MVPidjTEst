package com.example.durma.retrofitrxjava.root;

import android.app.Application;

import com.example.durma.retrofitrxjava.ApiModule;

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
                .apiModule(new ApiModule())
                .build();
    }

/*    public App(ApplicationComponent component) {
        this.component = component;
    }*/

    public ApplicationComponent getComponent() {
        return component;
    }
}
