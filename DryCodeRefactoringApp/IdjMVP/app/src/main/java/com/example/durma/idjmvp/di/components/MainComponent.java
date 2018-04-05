package com.example.durma.idjmvp.di.components;

import com.example.durma.idjmvp.Utils.Main.MainActivity;
import com.example.durma.idjmvp.di.module.MainModule;
import com.example.durma.idjmvp.di.scope.PerActivity;

import dagger.Component;

@PerActivity
@Component(modules = MainModule.class,dependencies = ApplicationCompontent.class)
public interface MainComponent {

    void inject(MainActivity mainActivity);
}
