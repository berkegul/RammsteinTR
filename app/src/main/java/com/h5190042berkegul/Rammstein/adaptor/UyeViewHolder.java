package com.h5190042berkegul.Rammstein.adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190042berkegul.Rammstein.R;

public class UyeViewHolder extends RecyclerView.ViewHolder {
    ImageView imgUYE;
    ImageView imgKapak;
    TextView txtAdiSoyadi;
    TextView txtDogumTarihi;
    TextView txtDogumYeri;
    TextView txtMeslegi;
    TextView txtCaldıgıEnsturmanlar;
    public UyeViewHolder(@NonNull View itemView , UyeAdaptor.OnItemClickListener listener) {
        super(itemView);
        txtAdiSoyadi =itemView.findViewById(R.id.txtAdiSoyadi);
        txtDogumTarihi =itemView.findViewById(R.id.txtDogumTarihi);
        txtDogumYeri =itemView.findViewById(R.id.txtDogumYeri);
        txtMeslegi = itemView.findViewById(R.id.txtMeslegi);
        txtCaldıgıEnsturmanlar=itemView.findViewById(R.id.txtCaldıgıEnsturmanlar);
        imgUYE =itemView.findViewById(R.id.imgUYE);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClik(getAdapterPosition());
            }
        });

    }
}
