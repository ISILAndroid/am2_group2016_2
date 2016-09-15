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

    /**
     * ESTE ES EL METODO PRINCIPAL EN LA ACTIVIDAD
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        //TODO el FragmentManager es quien gestiona los fragments
        fragmentManager= getSupportFragmentManager();

        //TODO de esta manera podemos invocar a los fragments que ESTAN en el diseño (XML)
        footerFragment= (FooterFragment) fragmentManager.findFragmentById(R.id.fragFooter);
        boxFragment= (BoxFragment) fragmentManager.findFragmentById(R.id.fragBox);
    }

    /**
     * ESTE METODO ES INVOCADO DESDE EL FOOTERFRAGMENT PARA LUEGO LLAMAR A UN METODO DEL BOXFRAGMENT
     * @param pos
     */
    @Override
    public void seleccionarColor(int pos) {
        boxFragment.recibirColoryPintar(pos);
    }
}
