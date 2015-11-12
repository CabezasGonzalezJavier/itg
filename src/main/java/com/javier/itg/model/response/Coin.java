package com.javier.itg.model.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by javiergonzalezcabezas on 12/11/15.
 */
public class Coin {
    private String response;
    private String currency;
    private List<Datum> data = new ArrayList<Datum>();
    private int mCode;
    private boolean mInterneterror;

    public boolean checkStatusCode(int status) {

        boolean successful = false;

        if (status >=200 && status<300){
            successful = true;
        }
        return successful;
    }

    public int getCode() {
        return mCode;
    }

    public void setCode(int code) {
        this.mCode = code;
    }

    public boolean isInterneterror() {
        return mInterneterror;
    }

    public void setInterneterror(boolean interneterror) {
        this.mInterneterror = interneterror;
    }

    /**
     *
     * @return
     * The response
     */
    public String getResponse() {
        return response;
    }

    /**
     *
     * @param response
     * The response
     */
    public void setResponse(String response) {
        this.response = response;
    }

    /**
     *
     * @return
     * The currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     *
     * @param currency
     * The currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     *
     * @return
     * The data
     */
    public List<Datum> getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(List<Datum> data) {
        this.data = data;
    }
}
