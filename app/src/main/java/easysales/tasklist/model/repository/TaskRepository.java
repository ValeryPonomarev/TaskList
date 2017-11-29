package easysales.tasklist.model.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import easysales.tasklist.database.SimpleDao;
import easysales.tasklist.model.Task;

/**
 * Created by lordp on 31.10.2017.
 */

public class TaskRepository implements Repository<Task> {
    private SimpleDao<Task> taskDao;

    public TaskRepository() {
        try {
            taskDao = Task.getDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public Task get(int id) {
        try {
            taskDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @NonNull
    @Override
    public List<Task> getAll() {
        List<Task> result = new ArrayList<>();
        try {
            result = taskDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void delete(@NonNull Task item) throws SQLException {
        taskDao.delete(item);
    }

    @Override
    public void create(@NonNull Task item) throws SQLException {
        taskDao.create(item);
    }

    @Override
    public void update(@NonNull Task item) throws SQLException {
        taskDao.update(item);
    }

    @Override
    public void save(@NonNull Task item) throws SQLException {
        taskDao.createOrUpdate(item);
    }
}
