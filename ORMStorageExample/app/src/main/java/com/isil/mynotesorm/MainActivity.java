package com.isil.mynotesorm;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.isil.mynotesorm.entity.NoteORMEntity;
import com.isil.mynotesorm.storage.PreferencesHelper;
import com.isil.mynotesorm.storage.dborm.NoteRepository;
import com.isil.mynotesorm.utils.StringUtils;
import com.isil.mynotesorm.view.adapters.NoteORMAdapter;

import java.util.List;


public class MainActivity extends ActionBarActivity {

    private static final String TAG ="MainActivity" ;
    private static final int ACTION_ADD=1;
    private static final int ACTION_DETAIL=2;

    private TextView tviLogout,tviUser;
    private ListView lstNotes;
    private Button btnAddNote;
    private List<NoteORMEntity> lsNoteORMEntities;
    private NoteORMAdapter noteORMAdapter;
    private NoteRepository noteRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //populateORM();
        init();
        //loadDataORM();
    }

    private void loadDataORM() {
        noteRepository= new NoteRepository(this);
        lsNoteORMEntities= noteRepository.getAAll();
        noteORMAdapter= new NoteORMAdapter(this,lsNoteORMEntities);
        lstNotes.setAdapter(noteORMAdapter);

        Log.v(TAG, "lsNoteEntities "+lsNoteORMEntities);
    }


    private void populateORM() {

        NoteRepository noteRepository= new NoteRepository(this);
        noteRepository.create(new NoteORMEntity("Mi Nota","Esta es un nota ",null));
        noteRepository.create(new NoteORMEntity("Segunda Nota","Esta es la segunds nota ",null));
        noteRepository.create(new NoteORMEntity("Tercera Nota","Esta es la tercera nota ",null));
        noteRepository.create(new NoteORMEntity("Cuarta Nota","Esta es la cuarta nota ",null));
        noteRepository.create(new NoteORMEntity("Quinta Nota","Esta es la quinta nota ",null));
        noteRepository.create(new NoteORMEntity("Sexta Nota","Esta es la sexta nota ",null));

        Log.v(TAG, "populate " + noteRepository.getRecentAll());
    }

    private void init() {
        tviLogout= (TextView)findViewById(R.id.tviLogout);
        tviUser= (TextView)findViewById(R.id.tviUser);
        lstNotes= (ListView)(findViewById(R.id.lstNotes));
        btnAddNote= (Button)(findViewById(R.id.btnAddNote));

        //user Info
        String username = PreferencesHelper.getUserSession(this);
        if(username!=null)
        {
            tviUser.setText("Bienvenido "+ StringUtils.firstCapitalize(username));
        }

        //events
        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoNote(ACTION_ADD, null);
            }
        });

        lstNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                NoteORMEntity noteEntity = (NoteORMEntity) adapterView.getAdapter().getItem(i);
                gotoNote(ACTION_DETAIL, noteEntity);
            }
        });

        tviLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });
    }

    private void gotoNote(int action, NoteORMEntity noteEntity) {
        Intent intent= new Intent(this,NoteActivity.class);

        switch (action)
        {
            case ACTION_ADD:
                    intent.putExtra("FRAGMENT",NoteActivity.ADD_NOTE);
                    startActivity(intent);
                break;
            case ACTION_DETAIL:
                intent.putExtra("FRAGMENT",NoteActivity.DETAIL_NOTE);
                intent.putExtra("NOTE", noteEntity);
                startActivity(intent);
                break;
        }
    }

    private void logout() {
        PreferencesHelper.signOut(this);
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "onResumen");
        loadDataORM();
    }

}
