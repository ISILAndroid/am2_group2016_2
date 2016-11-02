package com.isil.mynotesorm.view.listeners;

import com.isil.mynotesorm.entity.NoteEntity;
import com.isil.mynotesorm.entity.NoteORMEntity;
import com.isil.mynotesorm.storage.dborm.NoteRepository;

/**
 * Created by emedinaa on 15/09/15.
 */
public interface OnNoteListener {

     NoteRepository getNoteORMOperations();

     void deleteNoteORM(NoteORMEntity noteEntity);
     void editNoteORM(NoteORMEntity noteEntity);
}
