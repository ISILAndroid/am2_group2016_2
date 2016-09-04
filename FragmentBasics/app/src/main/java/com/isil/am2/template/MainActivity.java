package com.isil.am2.template;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private View btnContacts;
    private View btnProducts;
    private View btnBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ui();
    }

    private void ui() {
        btnContacts= findViewById(R.id.btnContacts);
        btnProducts= findViewById(R.id.btnProducts);
        btnBooks= findViewById(R.id.btnBooks);

        btnContacts.setOnClickListener(this);
        btnProducts.setOnClickListener(this);
        btnBooks.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnContacts:
                    gotoContacts();
                break;
            case R.id.btnProducts:
                    gotoProducts();
                break;
            case R.id.btnBooks:
                    gotoBooks();
                break;
        }
    }

    private void gotoContacts() {
        startActivity(new Intent(this,ContactsActivity.class));
    }

    private void gotoProducts() {
        startActivity(new Intent(this,ProductsActivity.class));
    }

    private void gotoBooks() {
        startActivity(new Intent(this,BooksActivity.class));
    }
}
