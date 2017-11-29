package easysales.tasklist.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

import easysales.tasklist.model.Task;

/**
 * Created by lordp on 16.07.2017.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private Context context;

    private static DatabaseHelper instance;
    public static final String DATABASE_NAME = "tasklist.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TAG = "DatabaseHelper";
    private static final AtomicInteger usageCounter = new AtomicInteger(0);

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        this.setWriteAheadLoggingEnabled(true);
    }

    public static DatabaseHelper getInstance(Context context) {
        if(instance == null) {
            instance = new DatabaseHelper(context);
        }
        usageCounter.incrementAndGet();
        return instance;
    }

    @Override
    public void close() {
        if(usageCounter.decrementAndGet() == 0){
            super.close();
            instance = null;
        }
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        Log.d(TAG, "create database");
        genereteDB();
    }

    //TODO Сделать возможность апгрейда бд без пересоздания таблиц

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        Log.d(TAG, "upgrade database");
        clearDB();
        onCreate(database, connectionSource);
    }

    private void genereteDB() {
        try {
            TableUtils.createTable(connectionSource, Task.class);
            createSampleData();
        } catch (SQLException e){
            e.printStackTrace();
        }

        Log.d(TAG, "Generate database is success");
    }

    private void clearDB() {
        try {
            TableUtils.dropTable(connectionSource, Task.class, true);
        } catch (SQLException e){
            e.printStackTrace();
        }

        Log.d(TAG, "Clear db is success");
    }

    private void createSampleData() throws SQLException {
        SimpleDao<Task> taskDao = Task.getDao();

        Task task1 = new Task();
        task1.setNumber("N1");
        task1.setDescription("description 1");

        Task task2 = new Task();
        task1.setNumber("N2");
        task1.setDescription("description 2");

        taskDao.create(task1);
        taskDao.create(task2);

    }
}
