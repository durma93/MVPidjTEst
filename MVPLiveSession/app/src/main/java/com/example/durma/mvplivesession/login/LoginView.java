package com.example.durma.mvplivesession.login;

/**
 * Created by durma on 13.3.18..
 */

public interface LoginView {

    void showProgress();
    void hideProgress();

    void setUserNameErorr();
    void setPasswordError();

    void navigateToMainActivity();

    void showAlert(String message);

}
