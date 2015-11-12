package com.javier.itg.utils;

import com.javier.itg.model.response.Coin;
import com.javier.itg.model.response.Datum;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by javiergonzalezcabezas on 12/11/15.
 */
public class Parser {

    /**
     * this method was created for parsing JSON
     */
    public static  Coin parserJSON(String data) {
        Coin coin = new Coin();
        try {
            JSONObject objectCoin = new JSONObject(data);
            String response = objectCoin.getString(Constants.RESPONSE);
            String currency = objectCoin.getString(Constants.CURRENCY);
            JSONArray jsonArray = objectCoin.getJSONArray(Constants.DATA);
            List<Datum> datumList = new ArrayList<>();
            for (int i = 0; i< jsonArray.length(); i++) {
                Datum datum = new Datum();
                String name = jsonArray.getJSONObject(i).getString(Constants.NAME);
                Integer jackpot = jsonArray.getJSONObject(i).getInt(Constants.JACKPOT);
                String date = jsonArray.getJSONObject(i).getString(Constants.DATE);

                datum.setName(name);
                datum.setJackpot(jackpot);
                datum.setDate(date);
                datumList.add(datum);
            }

            coin.setResponse(response);
            coin.setCurrency(currency);
            coin.setData(datumList);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return coin;
    }

}
