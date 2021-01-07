package com.aiphone.aiphone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class DetailActivity extends AppCompatActivity {

    private TextView judul, harga, deskripsi;
    private ImageView gambarprodak;
    private Button btBeli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        judul = findViewById(R.id.detailJudulProdak);
        harga = findViewById(R.id.detailHargaProdak);
        deskripsi = findViewById(R.id.detailDeskripsiProdak);
        gambarprodak = findViewById(R.id.detailGambarProdak);
        btBeli = findViewById(R.id.btBeli);

        Intent intent = getIntent();
        String detailJudul = intent.getStringExtra("JUDUL");
        String detailHarga = intent.getStringExtra("HARGA");
        String detailDeskripsi = intent.getStringExtra("DESKRIPSI");
        String detailGambar = intent.getStringExtra("GAMBAR");

        judul.setText(detailJudul);
        harga.setText(detailHarga);
        deskripsi.setText(detailDeskripsi);
        Glide.with(this).load(detailGambar).diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(gambarprodak);

        btBeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentToWhatsapp();
            }
        });
    }

    private void intentToWhatsapp() {
        String phoneNumberWithCountryCode = "+6285156515191";
        String message =
                "Hallo saya ingin memesan "
                + getIntent().getStringExtra("JUDUL");

        startActivity(
                new Intent(Intent.ACTION_VIEW,
                        Uri.parse(
                                String.format("https://api.whatsapp.com/send?phone=%s&text=%s",
                                        phoneNumberWithCountryCode, message)
                        )
                )
        );
    }
}