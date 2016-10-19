package com.isil.mynotes.view.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.isil.mynotes.R;
import com.isil.mynotes.model.entity.FacultyEntity;
import com.isil.mynotes.storage.db.FacultyOperations;
import com.isil.mynotes.storage.db.MyDatabase;
import com.isil.mynotes.view.adapters.FacultyAdapter;
import com.isil.mynotes.view.listeners.OnNavListener;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link FacultyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FacultyFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG ="FacultyFragment" ;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnNavListener mListener;
    private ListView lstFaculty;
    private List<FacultyEntity> faculties;
    private FacultyAdapter facultyAdapter;

    public FacultyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FacultyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FacultyFragment newInstance(String param1, String param2) {
        FacultyFragment fragment = new FacultyFragment();
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
        View view= inflater.inflate(R.layout.fragment_faculty, container, false);
        lstFaculty=(ListView) view.findViewById(R.id.lstFaculty);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FacultyOperations facultyOperations= new FacultyOperations(new MyDatabase(getActivity()));
        faculties = facultyOperations.getAllFaculties();

        Log.v(TAG, String.format("faculties %s ",faculties.size()));
        facultyAdapter= new FacultyAdapter(getActivity(),faculties);
        lstFaculty.setAdapter(facultyAdapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnNavListener) {
            mListener = (OnNavListener) context;
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

}
