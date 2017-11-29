package easysales.tasklist.model.repository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lordp on 03.11.2017.
 */

@Module
public class RepositoryModule {

    @Provides
    TaskRepository provideTaskRepository() {
        return new TaskRepository();
    }
}
