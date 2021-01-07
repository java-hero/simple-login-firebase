package com.aiphone.aiphone.model;

public class Produk {
    private String judul_produk;
    private String gambar;
    private String harga;
    private String deskripsi;

    public Produk() {
        this.judul_produk = judul_produk;
        this.gambar = gambar;
        this.harga = harga;
        this.deskripsi = deskripsi;
    }

    public String getJudul_produk() {
        return judul_produk;
    }

    public void setJudul_produk(String judul_produk) {
        this.judul_produk = judul_produk;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
