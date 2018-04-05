package com.example.durma.dager2_retrofit_rx_databasemvp.mvp.view;

import com.example.durma.dager2_retrofit_rx_databasemvp.mvp.model.Cake;

import java.util.List;

/**
 * Created by durma on 13.3.18..
 */

public interface MainView extends BaseView {
    void onCakeLoaded(List<Cake> cakes);

    void onShowDialog(String message);

    void getHideDialog();

    void onShowToast(String message);
}
