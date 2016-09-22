## Preferencias de Usuario (Shared Preferences)

- Este tipo de persitencia de datos te permite guardar elementos del tipo < Key, Value >, 
  donde normalmente los valores son variables primitivas , por ejemplo double, boolean, String.
- Mientras no elimines la app del dispositivo o borres la cache ,podrás acceder o editar a  los elementos 
  guardados y se podrán acceder desde cualquier componente. Ejemplo Activity, Fragment , Service

<img src="https://github.com/ISILAndroid/am2_group2016_2/blob/Lesson4/BorrarCache.png" height="320">
- Podemos tener un instancia del Shared Preferences de la siguiente manera :
  
  ```
      public static final String PREFS_NAME = "MyPrefsFile";
      
      SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

  ```
- Si necesitamos obtener un elemento de las preferencias
  ```
      SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
      
      boolean silent = settings.getBoolean("silentMode", false);
  ```
- Cuando sea requerido editar
  ```
    SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
    
    SharedPreferences.Editor editor = settings.edit();
    
    editor.putBoolean("silentMode", mSilentMode);

    // Commit the edits!
    editor.commit();
  ```
- O si debemos limpiar las preferencias
  ```
    SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    
    settings.edit().clear().commit();
  ```
  

### Actividad Grupal
  - Validar sesión del usuario

<img src="https://github.com/ISILAndroid/am2_group2016_2/blob/Lesson4/MyNotesSessionFlow.png" height="480">
