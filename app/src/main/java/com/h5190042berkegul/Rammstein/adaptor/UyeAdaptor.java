package com.h5190042berkegul.Rammstein.adaptor;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190042berkegul.Rammstein.R;
import com.h5190042berkegul.Rammstein.model.UyelerModel;
import com.h5190042berkegul.Rammstein.util.GlideUtil;

import java.util.List;
public class UyeAdaptor extends RecyclerView.Adapter<UyeViewHolder> {
    List<UyelerModel> uyeler;
    Context context;
    OnItemClickListener listener;

    public interface OnItemClickListener {void onClik(int position);}
    public UyeAdaptor(List<UyelerModel> uyeler, Context context,OnItemClickListener listener) {
        this.uyeler = uyeler;
        this.context = context;
        this.listener = listener;
    }
    @NonNull
    @Override
    public UyeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_uyeler,parent,false);
        return new UyeViewHolder(itemView,listener);
    }
    // ViewHolder üzerinde ki textboxların içleri uygun değişkenler ile dolduruldu
    @Override
    public void onBindViewHolder(@NonNull UyeViewHolder viewHolder, int position) {
        viewHolder.txtAdiSoyadi.setText(uyeler.get(position).getAdiSoyadi());
        viewHolder.txtMeslegi.setText(uyeler.get(position).getMeslegi());
        viewHolder.txtDogumTarihi.setText(uyeler.get(position).getDogumTarihi());
        viewHolder.txtDogumYeri.setText(uyeler.get(position).getDogumYeri());
        viewHolder.txtCaldıgıEnsturmanlar.setText(uyeler.get(position).getCaldıgıEnsturmanlar());
        GlideUtil.resmiIndiripGoster(context,uyeler.get(position).getResim(),viewHolder.imgUYE);



    }
    @Override
    public int getItemCount() {
        return uyeler.size();
    }
}
