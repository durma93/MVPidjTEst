package com.example.durma.idjmvptest.di.components;

import com.example.durma.idjmvptest.MainActivity;
import com.example.durma.idjmvptest.di.module.MainModule;
import com.example.durma.idjmvptest.di.scope.PerActivity;

import dagger.Component;

@PerActivity
@Component(modules = MainModule.class,dependencies = ApplicationCompontent.class)
public interface MainComponent {

    void inject(MainActivity mainActivity);
}
