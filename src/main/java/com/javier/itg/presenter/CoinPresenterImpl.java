package com.javier.itg.presenter;

import android.os.AsyncTask;

import com.javier.itg.model.response.Coin;
import com.javier.itg.utils.Parser;
import com.javier.itg.utils.Utils;
import com.javier.itg.view.CoinView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by javiergonzalezcabezas on 12/11/15.
 */
public class CoinPresenterImpl extends AsyncTask<String, Void, Coin> implements CoinPresenter {
    private CoinView mCoinView;

    public CoinPresenterImpl(CoinView mCoinView) {
        this.mCoinView = mCoinView;
    }


    @Override
    public void executeAsync(String url, String type) {
        this.execute(url, type);
    }

    @Override
    protected Coin doInBackground(String... params) {
        final String url = params[0];
        final String type = params[1];


        return callClient(url, type);
    }

    @Override
    protected void onPostExecute(Coin response) {
        super.onPostExecute(response);

        if (response.isInterneterror()) {

            mCoinView.onGeneralError();

        } else {
            if (response.checkStatusCode(response.getCode())) {
                mCoinView.onRequestSuccess(response);
            } else {
                mCoinView.onRequestError(response);
            }

        }

    }

    @Override
    public Coin callClient(String url, String type) {
        Coin responseModel = new Coin();
        String responseJson;

        try {
            URL obj = new URL(url);

            HttpURLConnection connection = HttpURLConnectionFactory.getHttpURLConnection(obj);

            connection.setRequestMethod(type);



            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            StringBuffer response = new StringBuffer();


            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            responseJson = response.toString();

            responseModel = Parser.parserJSON(response.toString());

            responseModel.setCode(connection.getResponseCode());
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
            responseJson = e.toString();
            responseModel.setInterneterror(true);
        }

        return responseModel;
    }
}
