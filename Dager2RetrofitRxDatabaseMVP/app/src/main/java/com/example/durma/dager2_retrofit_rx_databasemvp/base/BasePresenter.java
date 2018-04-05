package com.example.durma.dager2_retrofit_rx_databasemvp.base;

import com.example.durma.dager2_retrofit_rx_databasemvp.mvp.view.BaseView;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by durma on 13.3.18..
 */

public class BasePresenter<V extends BaseView> {

    @Inject protected V mView;

    public V getView(){
        return mView;
    }

    protected <T> void subscribe(Observable<T> observable,Observer<T> observer){
        observable.subscribeOn(Schedulers.newThread()).
                toSingle()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

}
