package easysales.tasklist.model.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import easysales.tasklist.model.Task;

/**
 * Created by lordp on 31.10.2017.
 */

public class TaskRepository {
    public static List<Task> getTaskList() {
        List<Task> result = new ArrayList<>();

        try {
            result.addAll(Task.getDao().queryForAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
