package com.isil.mynotes.storage.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.isil.mynotes.model.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserOperations {

	private MyDatabase helper;
	public UserOperations(SQLiteOpenHelper _helper) {
		super();
		// TODO Auto-generated constructor stub
		helper =(MyDatabase)_helper;
	}

	public void addUser(UserEntity userEntity)
	{
		 SQLiteDatabase db = helper.getWritableDatabase(); //modo escritura
		 ContentValues values = new ContentValues();
		 values.put(MyDatabase.USER_KEY_EMAIL, userEntity.getEmail());
		 values.put(MyDatabase.USER_KEY_PASSWORD, userEntity.getPassword());
		 
		 db.insert(MyDatabase.TABLE_USERS, null, values);
		 db.close();
	}


	public boolean logIn(String username, String password){

		SQLiteDatabase db = helper.getReadableDatabase(); //modo lectura
		Cursor cursor=db.rawQuery("SELECT * FROM "+MyDatabase.TABLE_USERS+" WHERE "+MyDatabase.USER_KEY_EMAIL+"='"+username+"' AND "+MyDatabase.USER_KEY_PASSWORD+"='"+password+"'",null);

		if(cursor!=null)
		{
			cursor.moveToFirst();
			if(cursor.getCount()<1)return false;
		}

		return true;
	}
	public UserEntity getUser(int id)
	{
		SQLiteDatabase db = helper.getReadableDatabase(); //modo lectura
		Cursor cursor = db.query(MyDatabase.TABLE_USERS,
				new String[]{MyDatabase.USER_KEY_ID, MyDatabase.USER_KEY_EMAIL,
						MyDatabase.USER_KEY_PASSWORD},
				MyDatabase.KEY_ID + "=?",
				new String[]{String.valueOf(id)}, null, null, null);
		if(cursor!=null)
		{
			cursor.moveToFirst();
		}
		int nid = Integer.parseInt(cursor.getString(0));
		String email = cursor.getString(1);
		String password = cursor.getString(2);

		UserEntity userEntity= new UserEntity(
				nid, email, password);
		return userEntity;
	}
	
	public List<UserEntity> getAllUser()
	{
		List<UserEntity> lst =new ArrayList<UserEntity>();
		String sql= "SELECT  * FROM " + MyDatabase.TABLE_USERS;
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor cursor = db.rawQuery(sql, null);
		if(cursor.moveToFirst())
		{
			do
			{
				UserEntity userEntity =new UserEntity();
				userEntity.setId(Integer.parseInt(cursor.getString(0)));
				userEntity.setEmail(cursor.getString(1));
				userEntity.setPassword(cursor.getString(2));

				lst.add(userEntity);
			}while(cursor.moveToNext());
		}
		return lst;
	}
	
	public int getUserCount()
	{
		String sql= "SELECT * FROM "+MyDatabase.TABLE_USERS;
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor cursor = db.rawQuery(sql, null);
		
		return cursor.getCount();
	}

}
