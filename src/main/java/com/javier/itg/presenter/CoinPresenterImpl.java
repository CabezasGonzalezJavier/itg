package com.javier.itg.presenter;

import android.os.AsyncTask;

import com.javier.itg.model.Bet;
import com.javier.itg.model.response.Coin;
import com.javier.itg.utils.Constants;
import com.javier.itg.utils.MergeModel;
import com.javier.itg.utils.Parser;
import com.javier.itg.utils.Utils;
import com.javier.itg.view.CoinView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by javiergonzalezcabezas on 12/11/15.
 */
public class CoinPresenterImpl  implements CoinPresenter {
    private Long mTime;
    private CoinView mCoinView;

    public CoinPresenterImpl(CoinView mCoinView) {
        this.mCoinView = mCoinView;
    }


    @Override
    public void execute(String url, String type) {
        if (Utils.readFromFile(mCoinView.getContext()).isEmpty()) {
            mTime = Calendar.getInstance().getTimeInMillis();

            new CallClient().execute(url, type);

        } else {

            Long currentMiliSeconds= Calendar.getInstance().getTimeInMillis();

            if (currentMiliSeconds>mTime+ Constants.MILISECONDS_PER_HOUR){
                new CallClient().execute(url, type);
            } else {
                new CallFile().execute();
            }

        }

    }



    public class CallClient extends AsyncTask<String, Void, Coin> {
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
                    new CallFile().execute();
                } else {
                    mCoinView.onRequestError(response);
                }

            }

        }

        public Coin callClient(String url, String type) {
            Coin responseModel = new Coin();

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

                Utils.writeToFile(response.toString(),mCoinView.getContext());
                responseModel = Parser.parserJSON(response.toString());

                responseModel.setCode(connection.getResponseCode());
                in.close();

            } catch (IOException e) {
                e.printStackTrace();
                responseModel.setInterneterror(true);
            }

            return responseModel;
        }


    }
    public class CallFile extends AsyncTask<String, Void, List<Bet>> {

        @Override
        protected List<Bet> doInBackground(String... params) {
            Coin responseModel = new Coin();
            responseModel = Parser.parserJSON(Utils.readFromFile(mCoinView.getContext()));
            return MergeModel.mergeModel(responseModel );
        }

        @Override
        protected void onPostExecute(List<Bet> response) {
            mCoinView.onRequestSuccess(response);
        }

    }
}
