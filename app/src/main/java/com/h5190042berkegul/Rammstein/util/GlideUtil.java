package com.h5190042berkegul.Rammstein.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GlideUtil {
    public  static  void resmiIndiripGoster(Context context, String url, ImageView img)
    {
               Glide.with(context)
                .load(url)
                .centerCrop()
                .into(img);
    }
}

