package com.example.durma.wiseassandoridarchitectualcomponent;

import android.app.Application;

import com.example.durma.wiseassandoridarchitectualcomponent.di.ApplicationComponent;
import com.example.durma.wiseassandoridarchitectualcomponent.di.ApplicationModule;
import com.example.durma.wiseassandoridarchitectualcomponent.di.DaggerApplicationComponent;
import com.example.durma.wiseassandoridarchitectualcomponent.di.RoomModule;

public class RoomDemoApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .roomModule(new RoomModule(this))
                .build();

    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
