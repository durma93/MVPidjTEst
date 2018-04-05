package com.example.durma.retrofitrxjava.root;


import com.example.durma.retrofitrxjava.ApiModule;
import com.example.durma.retrofitrxjava.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by durma on 9.3.18..
 */

@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface  ApplicationComponent  {

    void inject(MainActivity target);
}
