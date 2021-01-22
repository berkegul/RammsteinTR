package com.h5190042berkegul.Rammstein.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.h5190042berkegul.Rammstein.R;
import com.h5190042berkegul.Rammstein.util.AlertDialogUtil;
import com.h5190042berkegul.Rammstein.util.NetworkUtil;

public class SplashActivity extends AppCompatActivity {

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();

    }

    public void init(){
        // timer 3000 ms olarak ayarlandı
        CountDownTimer countDownTimer = new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long l) {
                Log.e("COUNTER", "TİCK");
            }
            @Override
            public void onFinish() { // süre bittiği oluşacak aksiyon yazıldı

                if(NetworkUtil.networkControl(getApplicationContext())) {
                    openNextActivity();
                }
                else { // eğer internet bağlantısı yok ise oluşucak aksiyon yazıldı
                    AlertDialogUtil.alertDialogShow(SplashActivity.this, getResources().getString(R.string.app_information),getResources()
                            .getString(R.string.app_netInformation),getResources().getString(R.string.app_goSettings),getResources()
                            .getString(R.string.app_no),getResources().getString(R.string.app_splashEkranBilgi));
                }
            }
        };
        countDownTimer .start();
    }
    public void openNextActivity(){ // yeni ekrana geçiş ayarlandı
        Log.e("COUNTER", "FİNİSH");
        Intent secondActivityIntent = new Intent(getApplicationContext(),UyelerActivity.class);
        startActivity(secondActivityIntent);
        finish();
    }
}
