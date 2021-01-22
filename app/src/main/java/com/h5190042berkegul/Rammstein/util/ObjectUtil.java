package com.h5190042berkegul.Rammstein.util;

import com.google.gson.Gson;
import com.h5190042berkegul.Rammstein.model.UyelerModel;

public class ObjectUtil {
            // json objeleri tanımlandı
    public  static String uyeToJsonString(UyelerModel uye)
    {
        Gson gson = new Gson();
        return   gson.toJson(uye);
    }

    public  static UyelerModel jsonStringToOyuncu(String jsonString)
    {
        Gson gson = new Gson();
        return  gson.fromJson(jsonString,UyelerModel.class);
    }
}
