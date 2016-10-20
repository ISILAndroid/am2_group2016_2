package com.isil.mynotes.storage.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.isil.mynotes.model.entity.GradeEntity;

import java.util.ArrayList;
import java.util.List;

public class GradeOperations {

	private MyDatabase helper;
	public GradeOperations(SQLiteOpenHelper _helper) {
		super();
		// TODO Auto-generated constructor stub
		helper =(MyDatabase)_helper;
	}

	public void addGrade(GradeEntity gradeEntity)
	{
		 SQLiteDatabase db = helper.getWritableDatabase(); //modo escritura
		 ContentValues values = new ContentValues();
		 values.put(MyDatabase.GRADE_KEY_COURSE, gradeEntity.getCourse());
		 values.put(MyDatabase.GRADE_KEY, gradeEntity.getGrade());
		 values.put(MyDatabase.GRADE_KEY_PHOTO, gradeEntity.getPhoto());
		 values.put(MyDatabase.GRADE_KEY_USER, gradeEntity.getUserId());

		 db.insert(MyDatabase.TABLE_GRADES, null, values);
		 db.close();
	}

	
	public List<GradeEntity> getAllGrades()
	{
		List<GradeEntity> lst =new ArrayList<GradeEntity>();
		String sql= "SELECT  * FROM " + MyDatabase.TABLE_GRADES;
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor cursor = db.rawQuery(sql, null);
		if(cursor.moveToFirst())
		{
			do
			{
				GradeEntity gradeEntity =new GradeEntity();
				gradeEntity.setId(Integer.parseInt(cursor.getString(0)));
				gradeEntity.setCourse(cursor.getString(1));
				gradeEntity.setGrade(cursor.getInt(2));
				gradeEntity.setPhoto(cursor.getString(3));
				gradeEntity.setUserId(cursor.getInt(4));

				lst.add(gradeEntity);
			}while(cursor.moveToNext());
		}
		return lst;
	}
	
	public int getGradeCount()
	{
		String sql= "SELECT * FROM "+MyDatabase.TABLE_GRADES;
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor cursor = db.rawQuery(sql, null);
		return cursor.getCount();
	}
}
