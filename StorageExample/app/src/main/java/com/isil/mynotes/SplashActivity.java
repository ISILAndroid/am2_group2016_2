package com.isil.mynotes;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.isil.mynotes.model.entity.FacultyEntity;
import com.isil.mynotes.model.entity.UserEntity;
import com.isil.mynotes.storage.PreferencesHelper;
import com.isil.mynotes.storage.db.FacultyOperations;
import com.isil.mynotes.storage.db.MyDatabase;
import com.isil.mynotes.storage.db.UserOperations;

import java.util.Timer;
import java.util.TimerTask;


public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_SCREEN_DELAY = 2000;
    private static final String TAG ="SplashActivity" ;
    private UserOperations userOperations;
    private FacultyOperations facultyOperations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TimerTask task = new TimerTask()
        {
            @Override
            public void run() {
                populateData();
                Intent intent;
                boolean session= PreferencesHelper.isSignedIn(SplashActivity.this);
                if(session)
                {
                    intent=new Intent(SplashActivity.this, DashboardActivity.class);
                }else {
                    intent = new Intent(SplashActivity.this, LoginActivity.class);
                }
                startActivity(intent);
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }

    private void populateData() {

        userOperations= new UserOperations(new MyDatabase(this));
        facultyOperations= new FacultyOperations(new MyDatabase(this));

        int users= userOperations.getUserCount();
        int faculties= facultyOperations.getFacultyCount();

        Log.v(TAG, String.format("DBParcial users %s + faculties %S ",users,faculties));
        if(users<=0) {
            //add user mock
            UserEntity userEntity = new UserEntity();
            userEntity.setEmail("admin");
            userEntity.setPassword("123");
            userOperations.addUser(userEntity);
        }
        if(faculties<=0){
            FacultyEntity facultyEntity= new FacultyEntity("Odontologìa",null);
            FacultyEntity facultyEntity1= new FacultyEntity("Medicina Humana",null);
            FacultyEntity facultyEntity2= new FacultyEntity("Derecho",null);
            FacultyEntity facultyEntity3= new FacultyEntity("Ingenierìa y Arquitectura",null);
            FacultyEntity facultyEntity4= new FacultyEntity("Ing Sistemas",null);
            FacultyEntity facultyEntity5= new FacultyEntity("Ing Quìmica",null);

            facultyOperations.addFaculty(facultyEntity);
            facultyOperations.addFaculty(facultyEntity1);
            facultyOperations.addFaculty(facultyEntity3);
            facultyOperations.addFaculty(facultyEntity4);
            facultyOperations.addFaculty(facultyEntity5);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return false;
    }
}
