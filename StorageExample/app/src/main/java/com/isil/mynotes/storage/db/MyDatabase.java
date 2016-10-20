package com.isil.mynotes.storage.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase extends SQLiteOpenHelper {


	public static final int DATABASE_VERSION = 1;
 
	public static final String DATABASE_NAME = "BDParcial";
 
    public static final String TABLE_NOTES = "tb_notes";
    public static final String TABLE_USERS = "tb_users";
    public static final String TABLE_FACULTIES = "tb_faculties";
    public static final String TABLE_GRADES = "tb_grades";

    //Columnas de la Tabla Notes
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_DESC = "desc";
    public static final String KEY_PATH = "path";

	//Columnas tabla User
	public static final String USER_KEY_ID = "id";
	public static final String USER_KEY_EMAIL= "email";
	public static final String USER_KEY_PASSWORD = "password";

	//Columnas Tabla Facultad

	public static final String FACULTY_KEY_ID = "id";
	public static final String FACULTY_KEY_TITLE= "title";
	public static final String FACULTY_KEY_PHOTO= "photo";

	//Columnas Tabla Grade
	public static final String GRADE_KEY_ID = "id";
	public static final String GRADE_KEY_COURSE= "course";
	public static final String GRADE_KEY= "grade";
	public static final String GRADE_KEY_PHOTO= "photo";
	public static final String GRADE_KEY_USER= "userdid";

    public MyDatabase(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
    
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String sql= "CREATE TABLE " + TABLE_NOTES + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," + KEY_NAME + " TEXT,"
				+ KEY_DESC + " TEXT,"
                + KEY_PATH + " TEXT" + ")";

		String userSql= "CREATE TABLE " + TABLE_USERS + "("
                + USER_KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," + USER_KEY_EMAIL + " TEXT,"
				+ USER_KEY_PASSWORD + " TEXT"+ ")";

		String facultySql= "CREATE TABLE " + TABLE_FACULTIES + "("
                + FACULTY_KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," + FACULTY_KEY_TITLE + " TEXT,"
				+ FACULTY_KEY_PHOTO + " TEXT"+ ")";

		String gradeSql= "CREATE TABLE " + TABLE_GRADES + "("
				+ GRADE_KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,"
				+ GRADE_KEY_COURSE + " TEXT,"
				+ GRADE_KEY + " INTEGER,"
				+ GRADE_KEY_PHOTO+ " TEXT,"
				+ GRADE_KEY_USER+" INTEGER"+ ")";

		db.execSQL(sql);
		db.execSQL(userSql);
		db.execSQL(facultySql);
		db.execSQL(gradeSql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		String sql= "DROP TABLE IF EXISTS " + TABLE_NOTES;
		String userSql= "DROP TABLE IF EXISTS " + TABLE_USERS;
		String facultySql= "DROP TABLE IF EXISTS " + TABLE_FACULTIES;
		String gradeSql= "DROP TABLE IF EXISTS " + TABLE_GRADES;

		db.execSQL(sql);
		db.execSQL(userSql);
		db.execSQL(facultySql);
		db.execSQL(gradeSql);
	}

}
