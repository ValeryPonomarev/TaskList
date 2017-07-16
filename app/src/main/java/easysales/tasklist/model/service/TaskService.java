package easysales.tasklist.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import easysales.tasklist.model.Task;

/**
 * Created by lordp on 16.07.2017.
 */

public class TaskService {

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
