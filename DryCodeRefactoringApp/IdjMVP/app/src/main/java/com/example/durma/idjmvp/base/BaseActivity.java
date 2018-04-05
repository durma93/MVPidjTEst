package com.example.durma.idjmvp.base;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.v7.app.AppCompatActivity;

import com.example.durma.idjmvp.application.IDJApplication;
import com.example.durma.idjmvp.di.components.ApplicationCompontent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity{
    private ProgressDialog mProgressDialog;
    public Unbinder unbinder;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContetView());

        unbinder = ButterKnife.bind(this);
        ButterKnife.bind(this);
        onViewReady(savedInstanceState, getIntent());

    }


    @CallSuper
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        resolveDaggerDependency();
        //To be used by child activity
    }

    protected void resolveDaggerDependency() {
    }

    protected void showProgressDialog(String message){
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mProgressDialog.setCancelable(true);
        }
        mProgressDialog.setMessage(message);
        mProgressDialog.show();
    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }

    protected void hideDialog(){

        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    protected ApplicationCompontent getApplicationCompontent(){
        IDJApplication application = (IDJApplication) getApplication();
        return application.getmApplicationCompontent();

    }

    protected abstract int getContetView();

}
