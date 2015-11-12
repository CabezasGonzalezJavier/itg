package com.javier.itg.model.response;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by javiergonzalezcabezas on 12/11/15.
 */
public class Datum implements Parcelable {
    private String name;
    private Integer jackpot;
    private String date;

    public Datum() {}

    public Datum(Parcel in) {
        name = in.readString();
        jackpot = in.readInt();
        date = in.readString();
    }

    public static final Creator<Datum> CREATOR = new Creator<Datum>() {
        @Override
        public Datum createFromParcel(Parcel in) {
            return new Datum(in);
        }

        @Override
        public Datum[] newArray(int size) {
            return new Datum[size];
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
    public Integer getJackpot() {
        return jackpot;
    }

    /**
     *
     * @param jackpot
     * The jackpot
     */
    public void setJackpot(Integer jackpot) {
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
        dest.writeInt(jackpot);
        dest.writeString(date);
    }
}
