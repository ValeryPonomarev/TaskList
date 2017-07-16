package easysales.tasklist;

import android.app.Application;

import easysales.tasklist.database.DatabaseHelper;

/**
 * Created by lordp on 16.07.2017.
 */

public class ApplicationWrapper extends Application {

    private static ApplicationWrapper instance;
    private static DatabaseHelper databaseHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        databaseHelper = DatabaseHelper.getInstance(this);
    }

    public static ApplicationWrapper getInstance() {
        return instance;
    }

    public DatabaseHelper getDatabaseHelper() {
        return databaseHelper;
    }
}
