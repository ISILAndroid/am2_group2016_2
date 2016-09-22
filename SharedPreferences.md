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
  Validar sesión del usuario
  * Para esto vamos a trabajar con las siguientes clases : SplashActivity.java , LogInActivity.java ,MainActivity.java y PreferencesHelper.java
  * La clase PreferencesHelper es un utilitario para manejar las preferencias en un solo lugar y de manera ordenada. Dandole la única responsabilidad de manejar las preferencias del usuario. Esta clase tiene 2 métodos principales donde se instancia las preferencias cada vez que sea necesario.
  
  ```
    private static SharedPreferences.Editor getEditor(Context context) {
        SharedPreferences preferences = getSharedPreferences(context);
        return preferences.edit();
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(MYNOTES_PREFERENCES, Context.MODE_PRIVATE);
    }
  ```
  * Tambien se declaro algunas constantes para el nombre de las Preferencias (única por app) , asi cómo métodos que me van a permitir saber si el usuario ya inició sesión , si requiero eliminar la sesión actual o si necesito guardar la sesión.
  ```
    private static final String MYNOTES_PREFERENCES = "mynotesPreferences";
    private static final String PREFERENCES_USERNAME = MYNOTES_PREFERENCES + ".username";
    private static final String PREFERENCES_PASSWORD = MYNOTES_PREFERENCES + ".password";
    
    public static void signOut(Context context) {
      SharedPreferences.Editor editor = getEditor(context);
      editor.remove(PREFERENCES_USERNAME);
      editor.remove(PREFERENCES_PASSWORD);
      editor.apply();
    }
    
    public static void saveSession(Context context,String username,String password)
    {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(PREFERENCES_USERNAME, username);
        editor.putString(PREFERENCES_PASSWORD, password);
        editor.apply();
    }
    
    public static boolean isSignedIn(Context context) {
        final SharedPreferences preferences = getSharedPreferences(context);
        return preferences.contains(PREFERENCES_USERNAME) &&
                preferences.contains(PREFERENCES_PASSWORD);
    }
  ```
  * En la clase SplashActivity, que es la primera que se ejecuta , nosotros debemos validar si ya existe un sesión y en base a eso decidir a que pantalla ir.
  
  ```
    Intent intent;
    boolean session= PreferencesHelper.isSignedIn(SplashActivity.this);
    if(session)
    {
        intent=new Intent(SplashActivity.this, MainActivity.class);
    }else {
      intent = new Intent(SplashActivity.this, LoginActivity.class);
    }
    startActivity(intent);
    finish();
  ```
  * En el caso que no se iniciara sesión , vamos a la clase LoginActivity donde simulamos una autenticación y guardamos la sesión actual
  ```
    private void init() {
      eteUsername=(EditText)findViewById(R.id.eteUsername);
      etePassword=(EditText)findViewById(R.id.etePassword);
      btnLogin=(Button)findViewById(R.id.btnLogin);

      btnLogin.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              if (validateForm()) {
                  gotoMain();
              }
          }
      });
    }

    private void gotoMain() {

        savePreferences();
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    private void savePreferences() {

        PreferencesHelper.saveSession(this,username,password);
    }
  ```

<img src="https://github.com/ISILAndroid/am2_group2016_2/blob/Lesson4/MyNotesSessionFlow.png" height="480">
