package com.isil.am2.template;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.isil.am2.template.model.BookEntity;
import com.isil.am2.template.ui.OnKindleListener;
import com.isil.am2.template.ui.fragments.BooksFragment;
import com.isil.am2.template.ui.fragments.FilterFragment;

public class BooksActivity extends AppCompatActivity implements OnKindleListener {

    private  final String TAG = "KindleActivity";
    private FilterFragment fragmentFilter;
    private BooksFragment booksFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        app();
    }

    private void app() {
        fragmentManager = getSupportFragmentManager();
        fragmentFilter = (FilterFragment) fragmentManager.findFragmentById(R.id.fragmentFilter);
        booksFragment = (BooksFragment) fragmentManager.findFragmentById(R.id.fragmentBooks);
    }

    @Override
    public void filterSelected(int position, Object object) {
        Log.v(TAG, "2. filterSelected " + position + " obj " + object);
        booksFragment.filtrar(position);
    }

    @Override
    public void gotoBookDetail(BookEntity bookEntity) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("BOOK", bookEntity);
        Intent intent = new Intent(this, BookDetailActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
