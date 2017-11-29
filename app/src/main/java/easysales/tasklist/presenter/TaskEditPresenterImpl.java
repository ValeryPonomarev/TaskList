package easysales.tasklist.presenter;

import android.util.Log;

import java.sql.SQLException;

import easysales.tasklist.model.Task;
import easysales.tasklist.model.service.TaskService;
import easysales.tasklist.presenter.base.BasePresenter;
import easysales.tasklist.view.TaskEditView;

/**
 * Created by lordp on 02.11.2017.
 */

public class TaskEditPresenterImpl extends BasePresenter<TaskEditView>
        implements  TaskEditPresenter {
    @Override
    public void saveTask(Task task) {
        TaskEditView.TaskData taskData = getView().getTaskData();
        task.setDescription(taskData.getDescription());
        TaskService.addSpendHours(task, taskData.getSpendTime());

        try {
            Task.getDao().createOrUpdate(task);
            Log.d(getUserTag(), "task save success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTask(Task task) {
        try {
            Task.getDao().delete(task);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onViewLoaded() {
        if(getView().getTask() != null) {
            getView().showTask(getView().getTask());
        }

    }
}
