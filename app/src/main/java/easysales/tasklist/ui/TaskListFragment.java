package easysales.tasklist.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.sql.SQLException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import easysales.tasklist.R;
import easysales.tasklist.model.Task;
import easysales.tasklist.model.service.TaskService;
import easysales.tasklist.ui.adapter.TaskRecycleListAdapter;
import easysales.tasklist.ui.base.BaseMainFragment;
import easysales.tasklist.ui.dialog.TaskEditDialog;


/**
 * A simple {@link Fragment} subclass.
 */
public class TaskListFragment extends BaseMainFragment implements TaskRecycleListAdapter.TaskViewHolder.OnItemClickListener {
    public static final String TAG = "TaskListFragment";

    private TaskRecycleListAdapter adapter;

    @BindView(R.id.task_list)
    RecyclerView taskRecyclerView;

    @BindView(R.id.add_task_button)
    Button addTaskButton;

    public TaskListFragment() {
        // Required empty public constructor
    }

    public static TaskListFragment newInstance() {
        TaskListFragment taskListFragment = new TaskListFragment();
        return taskListFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);
        ButterKnife.bind(this, view);
        adapter = new TaskRecycleListAdapter(TaskService.getTaskList(), this);
        taskRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        taskRecyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onItemClick(Task task) {
        Log.d(getUserTag(), "edit task");
        if(activity == null) {
            Toast.makeText(this.getContext(), "Oops, something is wrond, activity is null", Toast.LENGTH_SHORT).show();
        }
        TaskEditDialog taskEditDialog = TaskEditDialog.newInstance(task);

        taskEditDialog.setConfirmRunnable(() -> {
            task.description = taskEditDialog.getDescription();
            TaskService.addSpendHours(task, taskEditDialog.getSpendTime());

            try {
                Task.getDao().createOrUpdate(task);
                Log.d(getUserTag(), "task save success");
                adapter.notifyDataSetChanged();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        taskEditDialog.show(getFragmentManager(), TaskEditDialog.TAG);
    }

    @Override
    public String getUserTag() {
        return TAG;
    }

    @OnClick(R.id.add_task_button)
    public void onAddTaskClick(View view) {
        Log.d(getUserTag(), "add new task");
        Task task = new Task();
        onItemClick(task);
    }
}
