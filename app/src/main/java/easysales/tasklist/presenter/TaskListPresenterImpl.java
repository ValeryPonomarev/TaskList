package easysales.tasklist.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;

import java.util.List;

import easysales.tasklist.model.Task;
import easysales.tasklist.presenter.base.BasePresenter;
import easysales.tasklist.view.TaskListView;
import easysales.tasklist.view.loader.TaskListLoader;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by lordp on 01.11.2017.
 */

public class TaskListPresenterImpl extends BasePresenter<TaskListView>
        implements  TaskListPresenter,
                    LoaderManager.LoaderCallbacks<List<Task>>  {

    @NonNull
    private LoaderManager loaderManager;

    public TaskListPresenterImpl(@NonNull LoaderManager loaderManager) {
        loaderManager = checkNotNull(loaderManager);
    }

    @Override
    public void onViewLoaded() {
        getView().refreshList();
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

    @Override
    public void onTaskEdited(Task task) {
        getView().refreshList();
    }


    @Override
    public Loader<List<Task>> onCreateLoader(int id, Bundle args) {
        return new TaskListLoader(getContext());
    }

    @Override
    public void onLoadFinished(Loader<List<Task>> loader, List<Task> data) {
        showTasks(data);
    }

    @Override
    public void onLoaderReset(Loader<List<Task>> loader) {

    }
}
