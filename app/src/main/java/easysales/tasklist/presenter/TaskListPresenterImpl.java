package easysales.tasklist.presenter;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.sql.SQLException;
import java.util.List;

import easysales.tasklist.model.Task;
import easysales.tasklist.model.repository.TaskRepository;
import easysales.tasklist.model.service.TaskService;
import easysales.tasklist.presenter.base.BasePresenter;
import easysales.tasklist.view.TaskListView;
import easysales.tasklist.view.adapter.TaskRecycleListAdapter;
import easysales.tasklist.view.dialog.TaskEditDialog;

/**
 * Created by lordp on 01.11.2017.
 */

public class TaskListPresenterImpl extends BasePresenter<TaskListView> implements TaskListPresenter {
    @Override
    public void onViewLoaded() {
        List<Task> tasks = TaskRepository.getTaskList();
        getView().showTasks(tasks);
    }

    @Override
    public String getUserTag() {
        return null;
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void destroy() {

    }

    @Override
    public void onTaskClick(Task task) {
        Log.d(getUserTag(), "edit task");
        getView().showTaskEditDialog(task);

    }

    @Override
    public void onAddTackClick() {
        Task task = new Task();
        getView().showTaskEditDialog(task);
    }
}
