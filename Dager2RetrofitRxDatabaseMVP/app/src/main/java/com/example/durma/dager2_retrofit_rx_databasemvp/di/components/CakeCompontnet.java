package com.example.durma.dager2_retrofit_rx_databasemvp.di.components;

import com.example.durma.dager2_retrofit_rx_databasemvp.di.module.CakeModule;
import com.example.durma.dager2_retrofit_rx_databasemvp.di.scope.PerActivity;
import com.example.durma.dager2_retrofit_rx_databasemvp.modules.home.MainActivity;

import dagger.Component;

/**
 * Created by durma on 13.3.18..
 */
@PerActivity
@Component(modules = CakeModule.class,dependencies = ApplicationCompontent.class)
public interface CakeCompontnet {

    void inject(MainActivity mainActivity);

}
