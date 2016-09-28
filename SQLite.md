## Persistencia de Datos (S4-S6)

  - Base de datos Sqlite
  - Ejemplos , CRUD
  
### Aplicación MyNotes

1. Lo primero es definir la entidad NoteEntity con las siguientes propiedades :
  ```
    public class NoteEntity implements Serializable {

    private int id;
    private String name;
    private String description;
    private String path;
    
    }
  ```
2. Para poder gestionar y definir nuesta base de datos creamos la clase MyDatabase que extiende de SQLiteOpenHelper. En esta clase definimos el nombre de la BD, la versión y las tablas que vamos a usar, en este caso seria TABLE_NOTES="tb_notes" y la BD DATABASE_NAME="BDNote"

 Tambien vamos a necesitar un query para crear las tablas, por ejemplo para tb_notes
  ```
      String sql= "CREATE TABLE " + TABLE_NOTES + "("
                    + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," + KEY_NAME + " TEXT,"
            + KEY_DESC + " TEXT,"
                    + KEY_PATH + " TEXT" + ")";
  ```

  ```
    package com.isil.mynotes.storage.db;

    import android.content.Context;
    import android.database.sqlite.SQLiteDatabase;
    import android.database.sqlite.SQLiteDatabase.CursorFactory;
    import android.database.sqlite.SQLiteOpenHelper;

    public class MyDatabase extends SQLiteOpenHelper {


      public static final int DATABASE_VERSION = 1;

      public static final String DATABASE_NAME = "BDNote";

        public static final String TABLE_NOTES = "tb_notes";

        //Columnas de la Tabla Contacts
        public static final String KEY_ID = "id";
        public static final String KEY_NAME = "name";
        public static final String KEY_DESC = "desc";
        public static final String KEY_PATH = "path";


        public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
      }

      @Override
      public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql= "CREATE TABLE " + TABLE_NOTES + "("
                    + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," + KEY_NAME + " TEXT,"
            + KEY_DESC + " TEXT,"
                    + KEY_PATH + " TEXT" + ")";
        db.execSQL(sql);
      }

      @Override
      public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        String sql= "DROP TABLE IF EXISTS " + TABLE_NOTES;
        db.execSQL(sql);
      }

    }
  ```
  
  
#### Listado de Notas
 - MainActivity.java 
 
   <img src="https://github.com/ISILAndroid/am2_group2016_1/blob/Lesson4/screenshots/Listado%20de%20Notas.png" height="480">
   
 ```
 private void populate() {

        CRUDOperations crudOperations= new CRUDOperations(new MyDatabase(this));
        crudOperations.addNote(new NoteEntity("Mi Nota","Esta es un nota ",null));
        crudOperations.addNote(new NoteEntity("Segunda Nota","Esta es la segunds nota ",null));
        crudOperations.addNote(new NoteEntity("Tercera Nota","Esta es la tercera nota ",null));
        crudOperations.addNote(new NoteEntity("Cuarta Nota","Esta es la cuarta nota ",null));
        crudOperations.addNote(new NoteEntity("Quinta Nota","Esta es la quinta nota ",null));
        crudOperations.addNote(new NoteEntity("Sexta Nota","Esta es la sexta nota ",null));

        Log.v(TAG, "populate " + crudOperations.getAllNotes());
    }
 ```
 
 ```
   private void loadData() {
        crudOperations= new CRUDOperations(new MyDatabase(this));
        lsNoteEntities= crudOperations.getAllNotes();
        noteAdapter= new NoteAdapter(this,lsNoteEntities);
        lstNotes.setAdapter(noteAdapter);

    }
 ```
 
#### Agregar Notas
#### Editar Notas
#### Eliminar Notas
 


  
