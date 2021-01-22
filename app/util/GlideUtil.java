package com.cagataymuhammet.hafta11.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.cagataymuhammet.hafta11.R;

public class GlideUtil {

    public  static  void resmiIndiripGoster(Context context, String url, ImageView img)
    {
        Glide.with(context)
                .load(url)
                .error(R.drawable.medipollogo)
                .centerCrop()
                .into(img);
    }
}
