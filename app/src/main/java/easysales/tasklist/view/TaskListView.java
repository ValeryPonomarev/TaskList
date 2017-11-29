package easysales.tasklist.view;

import android.support.annotation.IdRes;

import java.util.List;

import easysales.tasklist.model.Task;
import easysales.tasklist.view.base.MvpView;

/**
 * Created by lordp on 01.11.2017.
 */

public interface TaskListView extends MvpView {
    void refreshList();
    void showTaskEditDialog(Task task);
}
