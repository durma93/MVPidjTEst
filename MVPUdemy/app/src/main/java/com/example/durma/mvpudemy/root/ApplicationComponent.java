package com.example.durma.mvpudemy.root;

import com.example.durma.mvpudemy.login.ActivityLogin;
import com.example.durma.mvpudemy.login.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by durma on 9.3.18..
 */

@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class})
public interface  ApplicationComponent  {

    void inject(ActivityLogin target);
}
