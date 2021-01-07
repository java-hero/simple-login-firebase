package com.aiphone.aiphone.utils;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.aiphone.aiphone.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;

public class BaseActivity extends AppCompatActivity {

    protected AppCompatActivity mActivity;
    protected GoogleSignInClient mGoogleSignInClient;
    protected GoogleSignInAccount mAccount;
    protected FirebaseAuth mAuth;
    protected GoogleSignInOptions mGso;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        mActivity = this;

//         Check for existing Google Sign In account, if the user is already signed in
        // the GoogleSignInAccount will be non-null.
        mAccount = GoogleSignIn.getLastSignedInAccount(this);

        // Configure Google Sign In
        mGso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

//         Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, mGso);

        //signInWithCredential
        mAuth = FirebaseAuth.getInstance();

    }

    // Setup Fragment
    protected void setupFragment(Fragment fragment, int layout) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(layout, fragment)
                .commit();
    }

}
