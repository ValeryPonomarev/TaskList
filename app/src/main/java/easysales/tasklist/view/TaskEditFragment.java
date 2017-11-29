package easysales.tasklist.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;
import easysales.tasklist.ApplicationWrapper;
import easysales.tasklist.R;
import easysales.tasklist.model.Task;
import easysales.tasklist.presenter.TaskEditPresenter;
import easysales.tasklist.presenter.base.MvpPresenter;
import easysales.tasklist.view.base.MvpFragment;

public class TaskEditFragment extends MvpFragment implements TaskEditView {
    private static final String ARG_TASK_ID = "TASK";
    private Task task;

    @Inject
    TaskEditPresenter presenter;

    public TaskEditFragment() { }

    public static TaskEditFragment newInstance(Integer taskId) {
        TaskEditFragment fragment = new TaskEditFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_TASK_ID, taskId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //TODO получение задачи
//            task = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task_edit, container, false);
        ButterKnife.bind(this, view);
        ApplicationWrapper.getAppComponent().injectTaskEditFragment(this);
        presenter.onViewLoaded();
        return view;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return presenter;
    }
}
