package com.isil.fragments;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.isil.fragments.view.fragments.OtherFragment;

public class DynamicFragActivity extends AppCompatActivity implements OtherFragment.OnFragmentInteractionListener {

    //flayContent

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_frag);

        addFragment();
    }

    private void addFragment() {

        OtherFragment newFragment = new OtherFragment();
        Bundle args = new Bundle();
        args.putInt("POSITION", 1);
        newFragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.flayContent, newFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
