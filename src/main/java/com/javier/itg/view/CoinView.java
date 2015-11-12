package com.javier.itg.view;

import android.content.Context;

import com.javier.itg.model.Bet;
import com.javier.itg.model.response.Coin;

import java.util.List;

/**
 * Created by javiergonzalezcabezas on 12/11/15.
 */
public interface CoinView {
    void showLoading(boolean state);
    void onRequestSuccess(List<Bet> betList);
    void onRequestError(Coin coin);
    void onGeneralError();

    Context getContext();
}
