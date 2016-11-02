# am2_group2016_2 Lesson 7

Persistencia de Datos (S4-S6)

- How to implement ORMLite Library

Steps

- Added ormlite dependency

```
	dependencies {
	    compile fileTree(dir: 'libs', include: ['*.jar'])


	    compile 'com.android.support:appcompat-v7:23.4.0'
	    compile 'com.android.support:support-v4:23.4.0'
	    compile 'com.android.support:design:23.4.0'
	    compile 'com.android.support:cardview-v7:23.4.0'
	    compile 'com.android.support:recyclerview-v7:23.4.0'
	    compile 'com.j256.ormlite:ormlite-android:4.48'
	}

```

- Update NoteEntity to NoteORMEntity

```
	package com.isil.mynotes.model.entity;

	import com.j256.ormlite.field.DatabaseField;
	import com.j256.ormlite.table.DatabaseTable;

	import java.io.Serializable;

	/**
	 * Created by eduardomedina on 2/11/16.
	 */

	@DatabaseTable(tableName = "note.tb")
	public class NoteORMEntity implements Serializable {


	    //@DatabaseField(id = true)
	    @DatabaseField(generatedId=true)
	    private int id;

	    @DatabaseField()
	    private String name;

	    @DatabaseField()
	    private String description;

	    @DatabaseField()
	    private String path;

	    @DatabaseField()
	    private String addedDate;

	    @DatabaseField()
	    private String color;

	    public NoteORMEntity() {
	    }

	    public NoteORMEntity(int id, String name, String description, String path) {
	        this.id = id;
	        this.name = name;
	        this.description = description;
	        this.path = path;
	    }

	    public NoteORMEntity(String name, String description, String path) {
	        this.name = name;
	        this.description = description;
	        this.path = path;
	    }

	    /*public NoteEntity(String name, String description, String path,String addedDate) {
	        this.name = name;
	        this.description = description;
	        this.path = path;
	        this.addedDate= addedDate;
	    }*/

	    public NoteORMEntity(String name, String description, String color,String addedDate) {
	        this.name = name;
	        this.description = description;
	        this.color = color;
	        this.addedDate= addedDate;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public String getPath() {
	        return path;
	    }

	    public void setPath(String path) {
	        this.path = path;
	    }

	    public String getAddedDate() {
	        return addedDate;
	    }

	    public void setAddedDate(String addedDate) {
	        this.addedDate = addedDate;
	    }

	    public String getColor() {
	        return color;
	    }

	    public void setColor(String color) {
	        this.color = color;
	    }

	}

```

- Added other class 

DataBaseManager	

```
	package com.isil.mynotesorm.storage.dborm;

	import android.content.Context;

	import com.j256.ormlite.android.apptools.OpenHelperManager;

	/**
	 * Created by Jay Rambhia on 05/04/15.
	 */
	public class DatabaseManager {
	    private DatabaseHelper databaseHelper = null;

	    public DatabaseHelper getHelper(Context context) {
	        if (databaseHelper == null) {
	            databaseHelper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
	        }

	        return databaseHelper;
	    }

	    public void releaseHelper() {
	        if (databaseHelper != null) {
	            OpenHelperManager.releaseHelper();
	            databaseHelper = null;
	        }
	    }
	}
```

DatabaseHelper

```
	package com.isil.mynotesorm.storage.dborm;

	import android.content.Context;
	import android.database.sqlite.SQLiteDatabase;
	import android.util.Log;

	import com.isil.mynotesorm.entity.NoteORMEntity;
	import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
	import com.j256.ormlite.dao.Dao;
	import com.j256.ormlite.dao.RuntimeExceptionDao;
	import com.j256.ormlite.support.ConnectionSource;
	import com.j256.ormlite.table.TableUtils;

	import java.sql.SQLException;

	/**
	 * Created by Jay Rambhia on 05/04/15.
	 */
	public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	    private static final String DATABASE_NAME = "MyNotes.db";
	    private static final int DATABASE_VERSION = 1;

	    private Dao<NoteORMEntity, Integer> noteDao = null;
	    private RuntimeExceptionDao<NoteORMEntity, Integer> noteRuntimeDao = null;

	    public DatabaseHelper(Context context) {
	        super(context, DATABASE_NAME, null, DATABASE_VERSION);
	    }

	    @Override
	    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
	        try {
	            TableUtils.createTable(connectionSource, NoteORMEntity.class);
	        } catch (SQLException e) {
	            Log.e(DatabaseHelper.class.getName(), "can't create database", e);
	            throw new RuntimeException(e);
	        }
	    }

	    @Override
	    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
	        try {
	            TableUtils.dropTable(connectionSource, NoteORMEntity.class, true);
	            onCreate(database, connectionSource);
	        } catch (SQLException e) {
	            Log.e(DatabaseHelper.class.getName(), "Can't drop database", e);
	            throw new RuntimeException(e);
	        }
	    }

	    @Override
	    public void close() {
	        super.close();
	        noteDao = null;
	    }

	    public RuntimeExceptionDao<NoteORMEntity, Integer> getNoteDataDao() {
	        if (noteRuntimeDao == null) {
	            noteRuntimeDao = getRuntimeExceptionDao(NoteORMEntity.class);
	        }

	        return noteRuntimeDao;
	    }

	    public Dao<NoteORMEntity, Integer> getNoteDao() throws SQLException {
	        if (noteDao == null) {
	            noteDao = getDao(NoteORMEntity.class);
	        }

	        return noteDao;
	    }

	}

```

NoteRepository

```
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

```




References 

* ORMLite [Link](http://ormlite.com/sqlite_java_android_orm.shtml)
* ORMLite Ejemplos [Link](http://ormlite.com/android/examples/)
  
  
