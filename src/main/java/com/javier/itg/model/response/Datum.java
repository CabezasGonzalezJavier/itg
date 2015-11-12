package com.javier.itg.model.response;

/**
 * Created by javiergonzalezcabezas on 12/11/15.
 */
public class Datum {
    private String name;
    private Integer jackpot;
    private String date;

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


}
