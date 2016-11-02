package com.isil.mynotesorm.storage.dborm;

import android.content.Context;
import android.util.Log;

import com.isil.mynotesorm.entity.NoteORMEntity;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Jay Rambhia on 05/04/15.
 */
public class NoteRepository {

    private static final String TAG = "NoteRepository";
    private DatabaseHelper dbHelper;
    private Dao<NoteORMEntity, Integer> noteDao;

    public NoteRepository(Context context) {
        DatabaseManager dbManager = new DatabaseManager();
        dbHelper = dbManager.getHelper(context);
        try {
            noteDao = dbHelper.getNoteDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int create(NoteORMEntity note) {
        try {
            return noteDao.create(note);
//            dbHelper.getDatab
        } catch (SQLException e) {
//            e.printStackTrace();
        }
        return 0;
    }

    public int update(NoteORMEntity note) {
        try {
            return noteDao.update(note);
        } catch (SQLException e) {
            e.printStackTrace();
            Log.v(TAG, "update exception " + e);
        }

        return 0;
    }

    public int delete(NoteORMEntity note) {
        try {
            return noteDao.delete(note);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public NoteORMEntity getById(int id) {
        try {
            return noteDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<NoteORMEntity> findAll() {
        try {
            return noteDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<NoteORMEntity> getRecentAll() {

        QueryBuilder<NoteORMEntity, Integer> qb = noteDao.queryBuilder();
        try {
            qb.orderBy(NoteORMEntity.TIMESTAMP_FIELD, false);
            PreparedQuery<NoteORMEntity> preparedQuery = qb.prepare();
            return noteDao.query(preparedQuery);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public long getNumberOfNotes() {
        QueryBuilder<NoteORMEntity, Integer> qb = noteDao.queryBuilder();
        try {
            return qb.countOf();
        } catch (SQLException e) {
            return -1;
        }
    }

    public List<NoteORMEntity> getRecentNotes(long limit) {
        if (limit < 1) {
            limit = 10;
        }

        QueryBuilder<NoteORMEntity, Integer> qb = noteDao.queryBuilder();
        try {
            qb.orderBy(NoteORMEntity.TIMESTAMP_FIELD, false);
            qb.limit(limit);
            PreparedQuery<NoteORMEntity> preparedQuery = qb.prepare();
            return noteDao.query(preparedQuery);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
