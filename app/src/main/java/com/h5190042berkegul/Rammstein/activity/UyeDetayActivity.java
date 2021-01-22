package com.h5190042berkegul.Rammstein.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.h5190042berkegul.Rammstein.R;
import com.h5190042berkegul.Rammstein.model.UyelerModel;
import com.h5190042berkegul.Rammstein.util.Constants;
import com.h5190042berkegul.Rammstein.util.GlideUtil;
import com.h5190042berkegul.Rammstein.util.ObjectUtil;

public class UyeDetayActivity extends AppCompatActivity {
    ImageView imgKAPAK;
    TextView txtBaslik;
    TextView txtHakkında;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uye_detay);
       init();
    }
    // Gerekli alanların doldurulması için bilgiler çekildi
    private void init(){
        String tasinanUYEString=getIntent().getStringExtra(Constants.TIKLANAN_UYE_ADI);
        UyelerModel uyelerModel = ObjectUtil.jsonStringToOyuncu(tasinanUYEString);
        imgKAPAK=findViewById(R.id.imageKAPAK);
        txtBaslik =findViewById(R.id.txtBaslik);
        txtHakkında=findViewById(R.id.txtHakkında);
        txtBaslik.setText(uyelerModel.getAdiSoyadi());
        GlideUtil.resmiIndiripGoster(getApplicationContext(),uyelerModel.getResim(),imgKAPAK);
        txtHakkında.setText(uyelerModel.getHakkında());
    }
    // Geri dönülmesi için onay sistemi kuruldu
    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertdialog=new AlertDialog.Builder(this);
        alertdialog.setMessage(getString(R.string.uyelerEmin));
        alertdialog.setCancelable(false).setPositiveButton(getString(R.string.uyelerEVET), new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.exit(0);

            }
        }).setNegativeButton(getString(R.string.uyelerHAYIR), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert=alertdialog.create();
        alert.show();
    }
}