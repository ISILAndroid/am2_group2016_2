package como.isil.mynotes.rest.view.listeners;

import como.isil.mynotes.rest.entity.NoteEntity;
import como.isil.mynotes.rest.storage.db.CRUDOperations;

/**
 * Created by emedinaa on 15/09/15.
 */
public interface OnNoteListener {

     CRUDOperations getCrudOperations();
     void deleteNote(NoteEntity noteEntity);
     void showParentLoading();
     void hideParentLoading();
     void showMessage(String message);
}
