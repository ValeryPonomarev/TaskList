package easysales.tasklist.presenter;

import easysales.tasklist.model.Task;
import easysales.tasklist.presenter.base.MvpPresenter;
import easysales.tasklist.view.TaskListView;

/**
 * Created by lordp on 01.11.2017.
 */

public interface TaskListPresenter extends MvpPresenter<TaskListView> {
    void onTaskClick(Task task);
    void onAddTackClick();
    void onTaskEdited(Task task);
}
