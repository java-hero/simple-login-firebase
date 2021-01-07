package com.aiphone.aiphone;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aiphone.aiphone.utils.BaseFragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class ProfileFragment extends BaseFragment {

    private TextView nama , email , notelp;
    private ImageView profile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nama = view.findViewById(R.id.nama);
        email = view.findViewById(R.id.email);
        notelp = view.findViewById(R.id.notelp);
        profile = view.findViewById(R.id.profilephoto);

        nama.setText(mAuth.getCurrentUser().getDisplayName());
        email.setText(mAuth.getCurrentUser().getEmail());
        notelp.setText(mAuth.getCurrentUser().getPhoneNumber());
        Glide.with(this).load(mAuth.getCurrentUser()
                .getPhotoUrl()).diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(profile);

    }
}