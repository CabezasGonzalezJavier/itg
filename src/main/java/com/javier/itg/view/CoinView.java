package com.javier.itg.view;

import android.content.Context;

import com.javier.itg.model.Bet;
import com.javier.itg.model.response.Coin;

import java.util.List;

/**
 * Created by javiergonzalezcabezas on 12/11/15.
 */
public interface CoinView {
    /**
     * this method was showing loadind
     */
    void showLoading(boolean state);
    /**
     * this method was created for requesting success
     */
    void onRequestSuccess(List<Bet> betList);
    /**
     * this method was created for requesting error
     */
    void onRequestError(Coin coin);
    /**
     * this method was created for requesting General error
     */
    void onGeneralError();

    /**
     * this method was created for geting
     */
    Context getContext();
}
