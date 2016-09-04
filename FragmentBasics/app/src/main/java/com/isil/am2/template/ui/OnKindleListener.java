package com.isil.am2.template.ui;


import com.isil.am2.template.model.BookEntity;

/**
 * Created by em on 30/03/16.
 */
public interface OnKindleListener {

    void filterSelected(int position, Object object);
    void gotoBookDetail(BookEntity bookEntity);

}
