package easysales.tasklist.presenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lordp on 01.11.2017.
 */

@Module
public class PresenterModule {

    @Provides
    TaskListPresenter provideTaskListPresenter() {
        return new TaskListPresenterImpl();
    }

    @Provides
    TaskEditPresenter provideTaskEditPresenter() {
        return new TaskEditPresenterImpl();
    }
}
