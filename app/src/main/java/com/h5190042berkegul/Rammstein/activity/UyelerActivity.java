package com.h5190042berkegul.Rammstein.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190042berkegul.Rammstein.R;
import com.h5190042berkegul.Rammstein.adaptor.UyeAdaptor;
import com.h5190042berkegul.Rammstein.model.UyelerModel;
import com.h5190042berkegul.Rammstein.network.Service;
import com.h5190042berkegul.Rammstein.util.Constants;
import com.h5190042berkegul.Rammstein.util.ObjectUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UyelerActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageView imgUYE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uyeler);
        init();
    }
    private  void  init()
    {
        uyeleriGETiR();
    }
// üyeleri ekrana çağırıldı
    private void  uyeleriGETiR()
    {
        new Service().getServiceApi().uyeGETiR().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<UyelerModel>>() {
                    List<UyelerModel> uyeler=new ArrayList<>();
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("RETROFIT","onSubscribe : ");
                    }
                    @Override
                    public void onNext(List<UyelerModel> uyeList) {
                        Log.e("RETROFIT","onNext : ");
                        uyeler=uyeList;
                    }
                    @Override
                    public void onError(Throwable e) {
                        Log.e("RETROFIT","onError : " + e.getLocalizedMessage());
                    }
                    @Override
                    public void onComplete()
                    {
                        Log.e("RETROFIT","onComplete : ");
                        if(uyeler.size()>0) {
                            initRecycleView(uyeler);
                        }
                    }
                });
    }
    // RecycleView de üyelerin gösterilmesi için bağlantılar yapıldı
    private  void  initRecycleView(List<UyelerModel>uyelerModelList )
    {
        //recyleview datasını ayarlıyoruz
        recyclerView =findViewById(R.id.rcvUyeler);
        UyeAdaptor uyeAdaptor =new UyeAdaptor(uyelerModelList, getApplicationContext(), new UyeAdaptor.OnItemClickListener() {
            @Override
            // seçilen üyeye tıklanıldağında oluşacak aksiyon belirlendi
            public void onClik(int position) {
                UyelerModel tiklanilanUYE=uyelerModelList.get(position);
                Toast.makeText(getApplicationContext(), getString(R.string.karsinizda)+ tiklanilanUYE.getAdiSoyadi() , Toast.LENGTH_SHORT).show();
                opennextActivity(tiklanilanUYE); // diyalog kapatıldı
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(uyeAdaptor);
    }
    private void opennextActivity(UyelerModel tiklanilanUYE){
        Log.e("COUNTER","FİNİSH");
        Intent secondActivityIntent=new Intent(getApplicationContext(), UyeDetayActivity.class);
        String tiklanilanUYEString= ObjectUtil.uyeToJsonString(tiklanilanUYE);
        secondActivityIntent.putExtra(Constants.TIKLANAN_UYE_ADI,tiklanilanUYEString);
        startActivity(secondActivityIntent);

    }

}