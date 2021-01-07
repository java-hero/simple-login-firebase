package com.aiphone.aiphone.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.aiphone.aiphone.DetailActivity;
import com.aiphone.aiphone.R;
import com.aiphone.aiphone.model.Produk;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

public class ProdukAdapter extends RecyclerView.Adapter<ProdukAdapter.ViewHolder> {

    private ArrayList<Produk> mData;
    private Context context;

    public ProdukAdapter(ArrayList<Produk> mData, Context context) {
        this.mData = mData;
        this.context = context;
    }

    @NonNull
    @Override
    public ProdukAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.list_produk,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdukAdapter.ViewHolder holder, int position) {
        Glide.with(context)
                .load(mData.get(position).getGambar())
                .diskCacheStrategy(DiskCacheStrategy.DATA).into(holder.gambar);
        holder.judul.setText(mData.get(position).getJudul_produk());
        holder.harga.setText("Rp. " + mData.get(position).getHarga());

        String judul = mData.get(position).getJudul_produk();
        String deskripsi = mData.get(position).getDeskripsi();
        String harga = mData.get(position).getHarga();
        String gambar = mData.get(position).getGambar();

        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("JUDUL",judul);
                intent.putExtra("DESKRIPSI",deskripsi);
                intent.putExtra("HARGA",harga);
                intent.putExtra("GAMBAR",gambar);
                context.startActivity(intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView judul , harga;
        private ImageView gambar;
        private CardView item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.judulProduk);
            gambar = itemView.findViewById(R.id.gambarproduk);
            harga = itemView.findViewById(R.id.hargaproduk);
            item = itemView.findViewById(R.id.itemproduk);
        }
    }
}
