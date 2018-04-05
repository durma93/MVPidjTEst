package com.example.durma.mvplivesession.login;

/**
 * Created by durma on 13.3.18..
 */

public class LoginPresenterImpl implements LoginPresenter,LoginInteractor.OnLoginFinishedListener {

    LoginView mLoginView;
    LoginInteractor mLoginIteractor;

    public LoginPresenterImpl(LoginView mLoginView) {
        this.mLoginView = mLoginView;
        mLoginIteractor = new LoginInteractorImpl();
    }

    @Override
    public void valitdateCredentials(String user, String pass) {

        if (mLoginView != null) {
            mLoginView.showProgress();
            mLoginIteractor.login(user,pass,this);
        }


    }

    @Override
    public void onDestroy() {

        if (mLoginView != null) {
             mLoginView = null;
        }

    }

    @Override
    public void onUserNameError() {
        if (mLoginView != null) {
            mLoginView.hideProgress();
            mLoginView.setUserNameErorr();
        }

    }

    @Override
    public void onPasswordError() {
        if (mLoginView != null) {
            mLoginView.hideProgress();
            mLoginView.setPasswordError();
        }
    }

    @Override
    public void onSuccess() {
        if (mLoginView != null) {
            mLoginView.hideProgress();
            mLoginView.navigateToMainActivity();
        }
    }

    @Override
    public void onFailure(String message) {
        if (mLoginView != null) {
            mLoginView.hideProgress();
            mLoginView.showAlert(message);
        }
    }
}
