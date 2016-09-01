package com.isil.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.isil.fragments.view.OnMyListener;

public class MyActivity extends AppCompatActivity  implements OnMyListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }
}
