package com.example.durma.mvplivesession.login;

/**
 * Created by durma on 13.3.18..
 */

public interface LoginPresenter {

    void valitdateCredentials(String user, String pass);

    void onDestroy();

}
