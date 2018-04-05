package com.example.durma.mvpudemy.login;

import java.security.PublicKey;

import dagger.Module;
import dagger.Provides;

/**
 * Created by durma on 9.3.18..
 */

@Module
public class LoginModule {

    @Provides
    public LoginActivityMVP.Presenter provideLoginActivityPresenter(LoginActivityMVP.Model model){
        return new LoginActivityPresenter(model);
    }

    @Provides
    public LoginActivityMVP.Model provideLoginActivityModel(LoginRepository loginRepository){
        return new LoginModel(loginRepository);
    }

    @Provides
    public LoginRepository provideLoginRepository(){
        return new MemoryRepository();
    }

}
