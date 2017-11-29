package easysales.tasklist;

import android.app.Application;

import com.google.gson.Gson;

import java.sql.SQLException;
import java.util.List;

import easysales.tasklist.database.DatabaseHelper;
import easysales.tasklist.database.SimpleDao;
import easysales.tasklist.model.Task;

/**
 * Created by lordp on 16.07.2017.
 */

public class ApplicationWrapper extends Application {

    private static ApplicationWrapper instance;
    private static DatabaseHelper databaseHelper;
    private static AppComponent appComponent;

    public static String APP_KEY = "easysales.tasklist";

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        databaseHelper = DatabaseHelper.getInstance(this);
        appComponent = DaggerAppComponent.create();
//        loadTestData();
    }

    public static ApplicationWrapper getInstance() {
        return instance;
    }

    public static DatabaseHelper getDatabaseHelper() {
        return databaseHelper;
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    private void loadTestData() {
        try {
            SimpleDao<Task> taskSimpleDao = Task.getDao();
            String testJson = getString(R.string.test_data);
            Gson gson = new Gson();
            List<Task> testTasks = gson.fromJson(testJson, Task.List.class);
            for(Task task : testTasks) {
                taskSimpleDao.create(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
