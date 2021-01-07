package com.aiphone.aiphone;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aiphone.aiphone.adapter.ProdukAdapter;
import com.aiphone.aiphone.model.Produk;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;

public class PromoFragment extends Fragment {

    private ArrayList<Produk> mData = new ArrayList<>();
    private RecyclerView recyclerView;
    private FirebaseFirestore firebaseFirestore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_promo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rvData);
        firebaseFirestore = FirebaseFirestore.getInstance();
        showData();
    }

    private void showData(){
        firebaseFirestore.collection("promo").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                for (QueryDocumentSnapshot queryDocumentSnapshots : task.getResult()){
                    Produk data = new Produk();
                    data.setJudul_produk(queryDocumentSnapshots.getString("judul_produk"));
                    data.setGambar(queryDocumentSnapshots.getString("gambar"));
                    data.setHarga(queryDocumentSnapshots.getString("harga"));
                    data.setDeskripsi(queryDocumentSnapshots.getString("deskripsi"));
                    mData.add(data);
                }
            }
            setRecyclerView(mData);
        });
    }

    private void setRecyclerView(ArrayList<Produk> arrayList){
        ProdukAdapter produkAdapter = new ProdukAdapter(arrayList, getActivity());
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setAdapter(produkAdapter);
    }
}