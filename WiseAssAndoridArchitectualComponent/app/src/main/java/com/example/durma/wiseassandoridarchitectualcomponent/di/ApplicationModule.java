package com.example.durma.wiseassandoridarchitectualcomponent.di;

import android.app.Application;

import com.example.durma.wiseassandoridarchitectualcomponent.RoomDemoApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private final Application application;

    public ApplicationModule(RoomDemoApplication application){
        this.application = application;
    }

    @Provides
    Application provideApplication(){
        return application;
    }
}
