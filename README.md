# am2_group2016_2

Ejercicio sobre uso de Callbacks para la comunidaciòn entre fragments

  <img src="https://github.com/ISILAndroid/am2_group2016_2/blob/Practice01/SampleColors.png" height="480">
  
  Este ejercicio se refiere a poder seleccionar un color de la barra inferior y  pintar en la parte superior el color correspondiente.
  
  1. Para esto vamos a crear un actividad llamada ColorActivity, este nos va a servir de contenedor para los Fragments.
  
  2. Luego vamos a necesitar crear 2 fragments , FooterFragment que contiene los botones con colores y BoxFragment que es un caja donde pintaremos el color elegido.
  
  3. Para poner tener esa distribuciòn (diseño) necesitamos modificar el XMl de ColorActivity, utilizar un layout tipo LinearLayout y jugar con los pesos en vertical. En este caso la proporciòn serìa de 8/2 o 7/3 , donde la parte superior tendria el mayor peso. En nuestro contenedor (LinearLayout) vamos a agregar los 2 fragment, BoxFragment primero y luego FooterFragment.
  
  BoxFragment
  ```
    package com.isil.fragments.view.fragments;

    import android.content.Context;
    import android.graphics.Color;
    import android.net.Uri;
    import android.os.Bundle;
    import android.support.annotation.Nullable;
    import android.support.v4.app.Fragment;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.FrameLayout;
    
    import com.isil.fragments.R;
    import com.isil.fragments.view.OnColorListener;
    
    /**
     * A simple {@link Fragment} subclass.
     * Activities that contain this fragment must implement the
     * interface
     * to handle interaction events.
     * Use the {@link BoxFragment#newInstance} factory method to
     * create an instance of this fragment.
     */
    public class BoxFragment extends Fragment {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private static final String ARG_PARAM1 = "param1";
        private static final String ARG_PARAM2 = "param2";
    
        // TODO: Rename and change types of parameters
        private String mParam1;
        private String mParam2;
    
        private OnColorListener mListener;
        private FrameLayout flayBox;
    
        public BoxFragment() {
            // Required empty public constructor
        }
    
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BoxFragment.
         */
        // TODO: Rename and change types and number of parameters
        public static BoxFragment newInstance(String param1, String param2) {
            BoxFragment fragment = new BoxFragment();
            Bundle args = new Bundle();
            args.putString(ARG_PARAM1, param1);
            args.putString(ARG_PARAM2, param2);
            fragment.setArguments(args);
            return fragment;
        }
    
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getArguments() != null) {
                mParam1 = getArguments().getString(ARG_PARAM1);
                mParam2 = getArguments().getString(ARG_PARAM2);
            }
        }
    
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_box, container, false);
        }
    
    
    
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
    
        @Override
        public void onDetach() {
            super.onDetach();
            mListener = null;
        }
    
        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            //CODE...
    
            flayBox= (FrameLayout)getView().findViewById(R.id.flayBox);
        }
    
        public void recibirColoryPintar(int position){
            int color=0;
            switch (position){
                case 0: //morado
                    color= Color.CYAN;
                    break;
                case 1://rojo
                    color= Color.RED;
                    break;
                case 2: //amarillo
                    color= Color.YELLOW;
                    break;
            }
            flayBox.setBackgroundColor(color);
        }
    
    }
  ```
  
  FooterFragment
  ```
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
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FooterFragment.
         */
        // TODO: Rename and change types and number of parameters
        public static FooterFragment newInstance(String param1, String param2) {
            FooterFragment fragment = new FooterFragment();
            Bundle args = new Bundle();
            args.putString(ARG_PARAM1, param1);
            args.putString(ARG_PARAM2, param2);
            fragment.setArguments(args);
            return fragment;
        }
    
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getArguments() != null) {
                mParam1 = getArguments().getString(ARG_PARAM1);
                mParam2 = getArguments().getString(ARG_PARAM2);
            }
        }
    
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_footer, container, false);
        }
    
    
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
    
        @Override
        public void onDetach() {
            super.onDetach();
            mListener = null;
        }
    
        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            //CODE...
    
            btnBox0= (Button)getView().findViewById(R.id.btnBox0);
            btnBox1= (Button)getView().findViewById(R.id.btnBox1);
            btnBox2= (Button)getView().findViewById(R.id.btnBox2);
    
            btnBox0.setOnClickListener(this);
            btnBox1.setOnClickListener(this);
            btnBox2.setOnClickListener(this);
        }
    
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
  ```
  
  
  
  
  4. Lo siguiente serìa definir un calback para poder "pasar" el color seleccionado de un Fragment a otro. Esto lo hacemos creando un interfaz llamada "OnColorListener" y creamos un mètodo llamado "seleccionarColor(color)" donde recibe como paràmetro el botòn seleccionado, es decir El primer botòn es 0, el siguiente 1, etc etc
  
  OnColorListener
  ```
    package com.isil.fragments.view;
    /**
     * Created by Profesor on 31/08/2016.
     */
    public interface OnColorListener {
    
        void seleccionarColor(int pos);
    }
  ```
  
  
  5. Para poder asociar este callback a los fragment necesitamos "agregarlo" al còdigo en cada uno de ellos . Los mètodos son "onAttach" y "onDetach"
  ```
    private OnColorListener mListener;
    
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
    
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
  ```
  
  6. xxxx

  
  
  
