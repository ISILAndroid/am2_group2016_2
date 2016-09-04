package com.isil.am2.template;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.isil.am2.template.ui.OnProductListener;

public class ProductsActivity extends AppCompatActivity implements OnProductListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
    }
}
