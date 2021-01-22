package com.cagataymuhammet.hafta11.network;

import com.cagataymuhammet.hafta11.model.Hoca;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {

    //base url
    //
    @GET("hocalar.json")
    Observable<List<Hoca>> ogretmenleriGetir();
}
