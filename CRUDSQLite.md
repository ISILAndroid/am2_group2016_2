## Persistencia de Datos (S4-S6)

  - CRUD  Sqlite
  
### Aplicación MyNotes

1. Agregar un nuevo Registro a la base de datos. Para esto debemos dividir este proceso en 2 partes :
  - La parte visual , es decir la interacción del usuario.
  - La parte lógica , donde tendremos la operación de agregar un registro.
  
  Vamos a trabajar en el fragment AddNoteFragment.java
  
  ```
        name= eteName.getText().toString().trim();
        desc= eteDesc.getText().toString().trim();
        note= eteNote.getText().toString().trim();
  ```
  
  ```
        NoteEntity noteEntity= new NoteEntity(name,desc,null);
        mListener.getCrudOperations().addNote(noteEntity);
  ```
  Despues de realizada esta acción salimos de vista
  ```
     @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        eteName=(EditText)getView().findViewById(R.id.eteName);
        eteDesc=(EditText)getView().findViewById(R.id.eteDesc);
        eteNote=(EditText)getView().findViewById(R.id.eteNote);
        btnAddNote=(Button)getView().findViewById(R.id.btnAddNote);

        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNote();
            }
        });
    }

    private void addNote() {
        name= eteName.getText().toString().trim();
        desc= eteDesc.getText().toString().trim();
        note= eteNote.getText().toString().trim();

        NoteEntity noteEntity= new NoteEntity(name,desc,null);
        mListener.getCrudOperations().addNote(noteEntity);

        getActivity().finish();

    }
  ```
  
2. Elimnar un registro de la base de datos. Para esto vamos hacer uso de los Callbacks (interfaces) para desde el fragment DetailFragment.java invocar un acción a la activity para eliminar la nota actual.

  DetailFragment
  ```
     btnDeleteNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.deleteNote(noteEntity);
            }
        });
  ```
  OnNoteListener
  
  ```
    package com.isil.mynotes.view.listeners;

    import com.isil.mynotes.model.entity.NoteEntity;
    import com.isil.mynotes.storage.db.CRUDOperations;

    /**
     * Created by emedinaa on 15/09/15.
     */
    public interface OnNoteListener {

         CRUDOperations getCrudOperations();
         void deleteNote(NoteEntity noteEntity);
    }
  ```
  
  NoteActivity
  
  ```
      @Override
    public void deleteNote(NoteEntity noteEntity) {
        MyDialogFragment myDialogFragment =new MyDialogFragment();
        Bundle bundle= new Bundle();
        bundle.putString("TITLE","¿Deseas eliminar esta nota?");
        bundle.putInt("TYPE",100);
        myDialogFragment.setArguments(bundle);
        myDialogFragment.show(getFragmentManager(), "dialog");
    }
  ```
   
   <img src="https://github.com/ISILAndroid/am2_group2016_2/blob/Lesson5/Agregar2.png" height="480">
     
   <img src="https://github.com/ISILAndroid/am2_group2016_2/blob/Lesson5/Editar_Eliminar.png" height="480">
   


  
