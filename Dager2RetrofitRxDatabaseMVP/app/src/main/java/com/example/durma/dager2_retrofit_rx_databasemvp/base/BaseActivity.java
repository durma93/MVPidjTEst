package com.example.durma.dager2_retrofit_rx_databasemvp.base;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.durma.dager2_retrofit_rx_databasemvp.application.CakeApplication;
import com.example.durma.dager2_retrofit_rx_databasemvp.di.components.ApplicationCompontent;
import com.example.durma.dager2_retrofit_rx_databasemvp.modules.home.MainActivity;

import java.nio.file.attribute.FileAttribute;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by durma on 13.3.18..
 */

public abstract class BaseActivity extends AppCompatActivity {

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
        CakeApplication application = (CakeApplication) getApplication();
        return application.getApplicationCompontent();

    }

    protected abstract int getContetView();
}
