package com.isil.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.isil.fragments.view.OnFragmentListener;

public class Main2Activity extends AppCompatActivity implements OnFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    public void onSendMessage(String msg) {

    }

    @Override
    public void comunicarFAconFB() {

    }

    @Override
    public void comunicarFBconFA() {

    }
}
