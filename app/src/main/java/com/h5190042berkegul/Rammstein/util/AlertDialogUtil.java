package com.h5190042berkegul.Rammstein.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;

import com.h5190042berkegul.Rammstein.R;

public class AlertDialogUtil {

    public static void alertDialogShow(Context context, String title, String message, String yes, String no ,String screen)
    {
        // alert için tanımlamalar yapıldı
        AlertDialog.Builder builder =new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface window, int i) {
                if(screen.toString() == context.getResources().getString(R.string.app_splashEkranBilgi)){
                    context.startActivity(new Intent(android.provider.Settings.ACTION_SETTINGS));
                }
                else{
                    ((Activity)context).onBackPressed();
                    ((Activity)context).finish();
                }

            }
        });

        builder.setNegativeButton(no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface window, int i) {
                if(screen.toString() == context.getResources().getString(R.string.app_splashEkranBilgi)){
                    ((Activity)context).finish();
                }
                else{
                    window.dismiss(); // ekran kapatıldı
                }

            }
        });
        builder.show(); // yapı gösterildi
    }

}