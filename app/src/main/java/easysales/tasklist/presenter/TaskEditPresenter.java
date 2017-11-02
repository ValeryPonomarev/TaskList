package easysales.tasklist.presenter;

import easysales.tasklist.model.Task;
import easysales.tasklist.presenter.base.MvpPresenter;
import easysales.tasklist.view.TaskEditView;

/**
 * Created by lordp on 02.11.2017.
 */

public interface TaskEditPresenter extends MvpPresenter<TaskEditView> {
    void saveTask(Task task);
    void deleteTask(Task task);
}
