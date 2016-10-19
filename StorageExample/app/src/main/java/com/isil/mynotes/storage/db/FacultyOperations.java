package com.isil.mynotes.storage.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.isil.mynotes.model.entity.FacultyEntity;

import java.util.ArrayList;
import java.util.List;

public class FacultyOperations {

	private MyDatabase helper;
	public FacultyOperations(SQLiteOpenHelper _helper) {
		super();
		// TODO Auto-generated constructor stub
		helper =(MyDatabase)_helper;
	}

	public void addFaculty(FacultyEntity facultyEntity)
	{
		 SQLiteDatabase db = helper.getWritableDatabase(); //modo escritura
		 ContentValues values = new ContentValues();
		 values.put(MyDatabase.FACULTY_KEY_TITLE, facultyEntity.getTitle());
		 values.put(MyDatabase.FACULTY_KEY_PHOTO, facultyEntity.getPhoto());
		 
		 db.insert(MyDatabase.TABLE_FACULTIES, null, values);
		 db.close();
	}

	
	public List<FacultyEntity> getAllFaculties()
	{
		List<FacultyEntity> lst =new ArrayList<FacultyEntity>();
		String sql= "SELECT  * FROM " + MyDatabase.TABLE_FACULTIES;
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor cursor = db.rawQuery(sql, null);
		if(cursor.moveToFirst())
		{
			do
			{
				FacultyEntity facultyEntity =new FacultyEntity();
				facultyEntity.setId(Integer.parseInt(cursor.getString(0)));
				facultyEntity.setTitle(cursor.getString(1));
				facultyEntity.setPhoto(cursor.getString(2));

				lst.add(facultyEntity);
			}while(cursor.moveToNext());
		}
		return lst;
	}
	
	public int getFacultyCount()
	{
		String sql= "SELECT * FROM "+MyDatabase.TABLE_FACULTIES;
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor cursor = db.rawQuery(sql, null);
		return cursor.getCount();
	}
}
