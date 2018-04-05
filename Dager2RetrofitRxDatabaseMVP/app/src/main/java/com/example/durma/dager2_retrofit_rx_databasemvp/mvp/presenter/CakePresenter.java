package com.example.durma.dager2_retrofit_rx_databasemvp.mvp.presenter;

import com.example.durma.dager2_retrofit_rx_databasemvp.api.CakeApiService;
import com.example.durma.dager2_retrofit_rx_databasemvp.base.BasePresenter;
import com.example.durma.dager2_retrofit_rx_databasemvp.mapper.CakeMapper;
import com.example.durma.dager2_retrofit_rx_databasemvp.mvp.model.Cake;
import com.example.durma.dager2_retrofit_rx_databasemvp.mvp.model.CakesResponse;
import com.example.durma.dager2_retrofit_rx_databasemvp.mvp.view.MainView;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;

/**
 * Created by durma on 13.3.18..
 */

public class CakePresenter extends BasePresenter<MainView> implements Observer<CakesResponse> {

    @Inject protected CakeApiService mApiService;

    @Inject protected CakeMapper mCakeMapper;

    @Inject
    public CakePresenter() {
    }

    public void getCakes() {
        getView().onShowDialog("Loading Cakes");
        Observable<CakesResponse> cakesResponseObservablees = mApiService.getCakes();

        subscribe(cakesResponseObservablees, this);


    }

    @Override
    public void onCompleted() {
        getView().getHideDialog();
        getView().onShowToast("Cake loading complite!");
    }

    @Override
    public void onError(Throwable e) {
        getView().getHideDialog();
        getView().onShowToast("Error loading cakes!" +e.getMessage());
    }

    @Override
    public void onNext(CakesResponse cakesResponse) {
        List<Cake> cakes = mCakeMapper.mapCakes(cakesResponse);
        getView().onCakeLoaded(cakes);
    }
}
