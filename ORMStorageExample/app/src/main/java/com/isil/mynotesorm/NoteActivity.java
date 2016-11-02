package com.isil.mynotesorm;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;

import com.isil.mynotesorm.entity.NoteORMEntity;
import com.isil.mynotesorm.storage.dborm.NoteRepository;
import com.isil.mynotesorm.view.dialogs.MyDialogFragment;
import com.isil.mynotesorm.view.dialogs.MyDialogListener;
import com.isil.mynotesorm.view.fragments.AddNoteFragment;
import com.isil.mynotesorm.view.fragments.DetailsFragment;
import com.isil.mynotesorm.view.listeners.OnNoteListener;

public class NoteActivity extends ActionBarActivity  implements OnNoteListener, MyDialogListener{

    public static final  int ADD_NOTE=100;
    public static final  int DETAIL_NOTE=101;
    public static final  int UPDATE_NOTE=102;
    private static final String TAG ="NoteActivity";

    private AddNoteFragment addNoteFragment= AddNoteFragment.newInstance(null,null);
    private DetailsFragment detailsFragment= DetailsFragment.newInstance(null,null);
    private int fragmentSelected= DETAIL_NOTE;
    private NoteORMEntity noteEntity;
    private NoteORMEntity currentNoteORM;

    private NoteRepository noteRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        validateExtras();

        noteRepository= new NoteRepository(this);
        Bundle bundle= new Bundle();
        bundle.putSerializable("NOTE",noteEntity);
        changeFragment(fragmentSelected, bundle);
    }

    private void validateExtras() {
        if(getIntent().getExtras()!=null)
        {
            fragmentSelected= getIntent().getExtras().getInt("FRAGMENT",DETAIL_NOTE);
            noteEntity= (NoteORMEntity) getIntent().getExtras().getSerializable("NOTE");
        }
    }


    private  void changeFragment(int id,Bundle bundle)
    {
        Fragment fragment= null;
        switch (id)
        {
            case ADD_NOTE:
                fragment=addNoteFragment;
                break;

            case DETAIL_NOTE:
                fragment=detailsFragment;
                break;

            case UPDATE_NOTE:
                fragment=null;
                break;
        }

        if(fragment!=null)
        {
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        }
    }




    @Override
    public NoteRepository getNoteORMOperations() {
        return noteRepository;
    }


    @Override
    public void deleteNoteORM(NoteORMEntity noteEntity) {
        currentNoteORM= noteEntity;
        MyDialogFragment myDialogFragment =new MyDialogFragment();
        Bundle bundle= new Bundle();
        bundle.putString("TITLE","¿Deseas eliminar esta nota?");
        bundle.putInt("TYPE",100);
        myDialogFragment.setArguments(bundle);
        myDialogFragment.show(getFragmentManager(), "dialog");
    }

    @Override
    public void editNoteORM(NoteORMEntity noteEntity) {
        noteRepository.update(noteEntity);
        finish();
    }

    @Override
    public void onPositiveListener(Object object, int type) {
        Log.v(TAG, "dialog positive");
        if(currentNoteORM!=null) {
            noteRepository.delete(currentNoteORM);
            finish();
        }
    }

    @Override
    public void onNegativeListener(Object object, int type) {
        Log.v(TAG, "dialog negative");
    }
}
