package com.example.durma.mvplivesession.login;

/**
 * Created by durma on 13.3.18..
 */

public interface LoginInteractor {

    interface OnLoginFinishedListener{

        void onUserNameError();
        void onPasswordError();
        void onSuccess();
        void onFailure(String message);

    }

    void login(String username, String password, OnLoginFinishedListener listener  );

}
