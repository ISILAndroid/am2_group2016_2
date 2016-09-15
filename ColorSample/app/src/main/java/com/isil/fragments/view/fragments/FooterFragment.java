package com.isil.fragments.view.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.isil.fragments.R;
import com.isil.fragments.view.OnColorListener;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 *  interface
 * to handle interaction events.
 * Use the {@link FooterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FooterFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnColorListener mListener;
    private Button btnBox0;
    private Button btnBox1;
    private Button btnBox2;

    public FooterFragment() {
        // Required empty public constructor
    }

    /**
     * ESTE METODO  VIENE POR DEFECTO AL CREAR UN FRAGMENT , ES UN SINGLETON
     */
    public static FooterFragment newInstance(String param1, String param2) {
        FooterFragment fragment = new FooterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * EN ESTE METODO SE CREA EL FRAGMENT
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    /**
     * EN ESTE METODO SE CARGA LA VISTA XML
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_footer, container, false);
    }

    /**
     * EN ESTE METODO EL FRAGMENT ES AGREGADO AL ACTIVITY
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnColorListener) {
            mListener = (OnColorListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    /**
     * EN ESTE METODO EL FRAGMENT ES REMOVIDO DEL ACTIVITY
     */
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * EN ESTE METODO PODEMOS ESCRIBIR NUESTRO CODIGO
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnBox0= (Button)getView().findViewById(R.id.btnBox0);
        btnBox1= (Button)getView().findViewById(R.id.btnBox1);
        btnBox2= (Button)getView().findViewById(R.id.btnBox2);

        btnBox0.setOnClickListener(this);
        btnBox1.setOnClickListener(this);
        btnBox2.setOnClickListener(this);
    }

    /**
     * EN ESTE METODO RECIBI LA ACCION DEL CLICK E INVOCA AL LISTENER (ACTIVITY)
     */
    @Override
    public void onClick(View v) {
        int pos=-1;
        switch (v.getId()){
            case R.id.btnBox0:
                     pos=0;
                break;
            case R.id.btnBox1:
                    pos=1;
                break;
            case R.id.btnBox2:
                    pos=2;
                break;
        }

        if(pos>=0){
            mListener.seleccionarColor(pos);
        }
    }
}
