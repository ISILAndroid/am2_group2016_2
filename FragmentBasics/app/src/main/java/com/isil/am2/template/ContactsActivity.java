package com.isil.am2.template;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.isil.am2.template.model.ContactEntity;
import com.isil.am2.template.ui.OnContactListener;
import com.isil.am2.template.ui.fragments.ContactsFragment;
import com.isil.am2.template.ui.fragments.DetailContactFragment;

public class ContactsActivity extends AppCompatActivity implements OnContactListener {

    private ContactsFragment contactsFragment;
    private DetailContactFragment detailContactFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        app();
    }

    private void app() {
        fragmentManager= getSupportFragmentManager();
        contactsFragment= (ContactsFragment)fragmentManager.findFragmentById(R.id.fragmentA);
        detailContactFragment= (DetailContactFragment)fragmentManager.findFragmentById(R.id.fragmentB);
    }

    @Override
    public void onSendMessage(String msg) {

    }

    @Override
    public void selectedItemContact(ContactEntity contactEntity) {
        detailContactFragment.renderContact(contactEntity);
    }
}
