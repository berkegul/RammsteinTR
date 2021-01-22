package com.h5190042berkegul.Rammstein.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class UyelerModel {
    @SerializedName("AdiSoyadi")
    @Expose
    private String adiSoyadi;
    @SerializedName("Meslegi")
    @Expose
    private String meslegi;
    @SerializedName("DogumTarihi")
    @Expose
    private String dogumTarihi;
    @SerializedName("DogumYeri")
    @Expose
    private String dogumYeri;
    @SerializedName("CaldıgıEnsturmanlar")
    @Expose
    private String caldıgıEnsturmanlar;
    @SerializedName("Resim")
    @Expose
    private String resim;
    @SerializedName("Hakkında")
    @Expose
    private String hakkında;
    public String getAdiSoyadi() {
        return adiSoyadi;
    }
    public void setAdiSoyadi(String adiSoyadi) {
        this.adiSoyadi = adiSoyadi;
    }
    public String getResim() { return resim; }
    public void setResim(){this.resim=resim;}
    public String getMeslegi() {
        return meslegi;
    }
    public void setMeslegi(String meslegi) {
        this.meslegi = meslegi;
    }
    public String getDogumTarihi() {
        return dogumTarihi;
    }
    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }
    public String getDogumYeri() {
        return dogumYeri;
    }
    public void setDogumYeri(String dogumYeri) {
        this.dogumYeri = dogumYeri;
    }
    public String getCaldıgıEnsturmanlar() {
        return caldıgıEnsturmanlar;
    }
    public void setCaldıgıEnsturmanlar(){this.caldıgıEnsturmanlar=caldıgıEnsturmanlar;}
    public String getHakkında(){return  hakkında;}
    public void setHakkında(){this.hakkında=hakkında;}


    }



