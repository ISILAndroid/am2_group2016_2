package com.isil.am2.template.ui;

import com.isil.am2.template.model.ContactEntity;

/**
 * Created by emedinaa on 25/08/15.
 */
public interface OnContactListener {

    void onSendMessage(String msg);
    void selectedItemContact(ContactEntity contactEntity);
}
