
Fragments

1. Activities & Fragments
![image](https://github.com/ISILAndroid/am2_group2016_2/blob/Lesson1/Fragments/Activities%20y%20Fragments%201.jpg)
![image](https://github.com/ISILAndroid/am2_group2016_2/blob/Lesson1/Fragments/Activities%20y%20Fragments%202.jpg)

2. Creación de Fragments
    - Por XMl
    
    ```
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools" android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal"
    tools:context="com.isil.fragments.HomeActivity">
        <fragment
            android:layout_weight="1"
            android:layout_width="0dp"
            android:layout_height="fill_parent"
            android:name="com.isil.fragments.view.fragments.AFragment"
            android:id="@+id/fragmentA"/>
    
        <fragment
            android:layout_weight="1"
            android:layout_width="0dp"
            android:layout_height="fill_parent"
            android:name="com.isil.fragments.view.fragments.BFragment"
            android:id="@+id/fragmentB"/>
    </LinearLayout>
    ```
    ```
        package com.isil.fragments;
        
        import android.support.v4.app.FragmentManager;
        import android.support.v7.app.ActionBarActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.Menu;
        import android.view.MenuItem;
        
        import com.isil.fragments.view.OnFragmentListener;
        import com.isil.fragments.view.fragments.AFragment;
        import com.isil.fragments.view.fragments.BFragment;
        
        
        public class HomeActivity extends ActionBarActivity implements OnFragmentListener {
        
            private static final String TAG = "HomeActivity";
        
            private AFragment fragmentA;
            private BFragment fragmentB;
            private FragmentManager fragmentManager;
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_home);
                init();
            }
        
            private void init() {
                fragmentManager= getSupportFragmentManager();
                fragmentA= (AFragment)fragmentManager.findFragmentById(R.id.fragmentA);
                fragmentB= (BFragment)fragmentManager.findFragmentById(R.id.fragmentB);
        
                Log.v(TAG, "fragment A"+fragmentA+ " fragment B "+fragmentB);
            }
        
            @Override
            public boolean onCreateOptionsMenu(Menu menu) {
                return false;
            }
        
            @Override
            public boolean onOptionsItemSelected(MenuItem item) {
                return false;
            }
        
            @Override
            public void onSendMessage(String msg) {
        
            }
        }
    ```
    
    - Por código
    ```
    package com.isil.fragments;
    import android.net.Uri;
    import android.support.v4.app.FragmentTransaction;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    
    import com.isil.fragments.view.fragments.OtherFragment;
    
    public class DynamicFragActivity extends AppCompatActivity implements OtherFragment.OnFragmentInteractionListener {
    
        //flayContent
    
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_dynamic_frag);
    
            addFragment();
        }
    
        private void addFragment() {
    
            OtherFragment newFragment = new OtherFragment();
            Bundle args = new Bundle();
            args.putInt("POSITION", 1);
            newFragment.setArguments(args);
    
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.flayContent, newFragment);
            transaction.addToBackStack(null);
    
            // Commit the transaction
            transaction.commit();
        }
    
        @Override
        public void onFragmentInteraction(Uri uri) {
    
        }
    }
    ```
3. Comunicación
    - Uso de Interfaces
    ![image](https://github.com/ISILAndroid/am2_group2016_2/blob/Lesson1/Fragments/Java%20Interfaces.png)

4.xxx
