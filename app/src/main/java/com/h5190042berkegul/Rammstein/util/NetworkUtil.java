package com.h5190042berkegul.Rammstein.util;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtil {

        // internet testi için gerekli aksiyonlar yazıldı
    public static boolean networkControl(Context context)
    {
        ConnectivityManager connectivityManager =(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo =connectivityManager.getActiveNetworkInfo();

        if(networkInfo!=null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return  true;
        }
        else {
            return  false;
        }

    }

}
