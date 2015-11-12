package com.javier.itg.view;

import android.content.Context;

import com.javier.itg.MainActivity;
import com.javier.itg.model.response.Coin;

/**
 * Created by javiergonzalezcabezas on 12/11/15.
 */
public interface CoinView {
    void showLoading(boolean state);
    void onRequestSuccess(Coin coin);
    void onRequestError(Coin coin);
    void onGeneralError();

    Context getContext();
}
