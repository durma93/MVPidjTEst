package com.example.durma.wiseassandoridarchitectualcomponent.di;

import android.app.Application;

import com.example.durma.wiseassandoridarchitectualcomponent.create.CreateFragment;
import com.example.durma.wiseassandoridarchitectualcomponent.detail.DetailFragment;
import com.example.durma.wiseassandoridarchitectualcomponent.list.ListFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class,RoomModule.class})
public interface ApplicationComponent {

    void inject(ListFragment listFragment);
    void inject(CreateFragment createFragment);
    void inject (DetailFragment detailFragment);

    Application application();

}
