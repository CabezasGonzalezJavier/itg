package com.javier.itg.presenter;

import com.javier.itg.model.response.Coin;

/**
 * Created by javiergonzalezcabezas on 12/11/15.
 */
public interface CoinPresenter {
    void executeAsync(String url, String type);
    Coin callClient(final String url, final String type);
}
