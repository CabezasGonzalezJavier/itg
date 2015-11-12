package com.javier.itg.view;

import android.content.Context;

import com.javier.itg.MainActivity;

/**
 * Created by javiergonzalezcabezas on 12/11/15.
 */
public interface CoinView {
    void showLoading(boolean state);
    void onRequestSuccess(Object object);
    void onRequestError(Object object);
    void onGeneralError();

    Context getContext();
}
