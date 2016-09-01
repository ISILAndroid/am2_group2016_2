package com.isil.fragments.view;

/**
 * Created by Profesor on 31/08/2016.
 */
public interface OnIsilListener {

    void gotoMain();
    void showMessage(String message);
    void showConfirmationDialog(String message);
    void closeApp();
}
