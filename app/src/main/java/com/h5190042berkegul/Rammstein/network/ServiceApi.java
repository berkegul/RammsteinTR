package com.h5190042berkegul.Rammstein.network;

import com.h5190042berkegul.Rammstein.model.UyelerModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {
    @GET("rammstein")
    Observable<List<UyelerModel>>uyeGETiR();
}
