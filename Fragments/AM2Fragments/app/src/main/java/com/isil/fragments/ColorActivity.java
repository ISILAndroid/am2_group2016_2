package com.isil.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.isil.fragments.view.OnColorListener;

public class ColorActivity extends AppCompatActivity implements OnColorListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
    }

    @Override
    public void seleccionarColor(int pos) {

    }
}
