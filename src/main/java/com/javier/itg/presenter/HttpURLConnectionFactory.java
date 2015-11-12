package com.javier.itg.presenter;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by javiergonzalezcabezas on 12/11/15.
 */
public class HttpURLConnectionFactory {
    private static HttpURLConnection sConnection;
    private static boolean hasmockConnection;

    public static HttpURLConnection getHttpURLConnection(URL url) throws IOException {



        if(!hasmockConnection){
            sConnection = (HttpURLConnection) url.openConnection();
        } else {
            hasmockConnection = false;
        }

        return sConnection;
    }

}
