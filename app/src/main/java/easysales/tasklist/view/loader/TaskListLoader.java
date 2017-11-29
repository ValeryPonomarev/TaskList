package easysales.tasklist.view.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;

import easysales.tasklist.model.Task;
import easysales.tasklist.model.repository.TaskRepository;

/**
 * Created by lordp on 02.11.2017.
 */

public class TaskListLoader extends AsyncTaskLoader<List<Task>> {
    public static int ID = 1;

    public TaskListLoader(Context context) {
        super(context);
    }

    @Override
    public List<Task> loadInBackground() {
        return TaskRepository.getTaskList();
    }
}
