package easysales.tasklist;

import dagger.Component;
import easysales.tasklist.presenter.PresenterModule;
import easysales.tasklist.view.TaskListFragment;
import easysales.tasklist.view.dialog.TaskEditDialog;

/**
 * Created by lordp on 01.11.2017.
 */

@Component(modules = {PresenterModule.class})
public interface AppComponent {
    void injectTaskListFragment(TaskListFragment taskListFragment);
    void injectTaskEditFragment(TaskEditDialog taskEditDialog);
}
