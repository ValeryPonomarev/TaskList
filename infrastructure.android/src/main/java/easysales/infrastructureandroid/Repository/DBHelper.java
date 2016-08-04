package easysales.infrastructureandroid.Repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by drmiller on 04.08.2016.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static DBHelper instance = null;

    private static final String TAG_LOG = "DBHelper";
    private String onCreateQuery;
    private String onUpdateQuery;
    private String tableName;

    private DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, String onCreateQuery, String onUpdateQuery) {
        super(context, name, factory, version);
        this.onCreateQuery = onCreateQuery;
        this.onUpdateQuery = onUpdateQuery;
        this.tableName = name;
    }
/*
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }
/**/

    public static DBHelper getInstance(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, String onCreateQuery, String onUpdateQuery)
    {
        if(instance == null) {
            instance = new DBHelper(context, name, factory, version, onCreateQuery, onUpdateQuery);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        if(onCreateQuery != null && onCreateQuery.length() > 0)
        {
            Log.d(TAG_LOG, onCreateQuery);
            db.execSQL(onCreateQuery);
            Log.d(TAG_LOG, String.format("Table %1$s has been created", this.tableName));
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(onUpdateQuery != null && onUpdateQuery.length() > 0)
        {
            Log.d(TAG_LOG, onUpdateQuery);
            db.execSQL(onUpdateQuery);
        }

        onCreate(db);
    }

}

