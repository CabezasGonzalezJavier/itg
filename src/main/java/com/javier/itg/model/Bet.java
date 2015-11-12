package com.javier.itg.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by javiergonzalezcabezas on 12/11/15.
 */
public class Bet implements Parcelable {
    private String name;
    private String jackpot;
    private String date;


    public Bet() {}
    public Bet(Parcel in) {
        name = in.readString();
        jackpot = in.readString();
        date = in.readString();
    }

    public static final Creator<Bet> CREATOR = new Creator<Bet>() {
        @Override
        public Bet createFromParcel(Parcel in) {
            return new Bet(in);
        }

        @Override
        public Bet[] newArray(int size) {
            return new Bet[size];
        }
    };

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The jackpot
     */
    public String getJackpot() {
        return jackpot;
    }

    /**
     *
     * @param jackpot
     * The jackpot
     */
    public void setJackpot(String jackpot) {
        this.jackpot = jackpot;
    }

    /**
     *
     * @return
     * The date
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     * The date
     */
    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(jackpot);
        dest.writeString(date);
    }
}

