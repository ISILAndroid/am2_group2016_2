package com.isil.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.isil.fragments.view.OnColorListener;
import com.isil.fragments.view.fragments.BoxFragment;
import com.isil.fragments.view.fragments.FooterFragment;

public class ColorActivity extends AppCompatActivity implements OnColorListener {

    private FooterFragment footerFragment;
    private BoxFragment boxFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        fragmentManager= getSupportFragmentManager();

        footerFragment= (FooterFragment) fragmentManager.findFragmentById(R.id.fragFooter);
        boxFragment= (BoxFragment) fragmentManager.findFragmentById(R.id.fragBox);
    }

    @Override
    public void seleccionarColor(int pos) {
        //Boxfragment
        boxFragment.recibirColoryPintar(pos);

    }
}
