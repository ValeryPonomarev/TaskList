package easysales.tasklist;

import dagger.Component;
import easysales.tasklist.model.repository.RepositoryModule;
import easysales.tasklist.presenter.PresenterModule;
import easysales.tasklist.view.TaskEditFragment;
import easysales.tasklist.view.TaskListFragment;
import easysales.tasklist.view.dialog.TaskEditDialog;

/**
 * Created by lordp on 01.11.2017.
 */

@Component(modules = {PresenterModule.class, RepositoryModule.class})
public interface AppComponent {
    void injectTaskListFragment(TaskListFragment taskListFragment);
    void injectTaskEditFragment(TaskEditDialog taskEditDialog);
    void injectTaskEditFragment(TaskEditFragment taskEditFragment);
}
