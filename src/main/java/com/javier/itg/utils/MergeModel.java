package com.javier.itg.utils;

import com.javier.itg.model.Bet;
import com.javier.itg.model.response.Coin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by javiergonzalezcabezas on 12/11/15.
 */
public class MergeModel {

    /**
     * this method was created for merging Model
     */
    public static List<Bet> mergeModel(Coin coin) {
        List<Bet> list = new ArrayList<>();
        for (int i = 0; i<coin.getData().size(); i++){
            Bet bet = new Bet();
            StringBuilder stringBuilder = new StringBuilder();
            bet.setName(coin.getData().get(i).getName());
            bet.setDate(converStringToDate(coin.getData().get(i).getDate()));
            stringBuilder.append(coin.getData().get(i).getJackpot());
            stringBuilder.append(" ");
            stringBuilder.append(coin.getCurrency());
            bet.setJackpot(stringBuilder.toString());
            list.add(bet);

        }
        return list;
    }


    /**
     * this method was created for converting Date for locale formatting.
     */
    public static String converStringToDate(String dateInString) {
        String returnString;
        String[] parts = dateInString.split("\\+");
        String partFormat = parts[0];
        String part2 = parts[1];
        part2.substring(0,0);

        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ssZ");
        SimpleDateFormat myFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            Date date = formatter.parse( dateInString.replaceAll(":(?=..$)", ""));
            returnString = myFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            returnString = e.toString();
        }
        return returnString;
    }
}
