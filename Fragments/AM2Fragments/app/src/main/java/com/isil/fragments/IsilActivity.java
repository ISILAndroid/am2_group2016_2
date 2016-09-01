package com.isil.fragments;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.isil.fragments.view.OnIsilListener;
import com.isil.fragments.view.fragments.IsilFragment;

public class IsilActivity extends AppCompatActivity implements OnIsilListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isil);
    }


    @Override
    public void gotoMain() {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showConfirmationDialog(String message) {

    }

    @Override
    public void closeApp() {

    }
}
