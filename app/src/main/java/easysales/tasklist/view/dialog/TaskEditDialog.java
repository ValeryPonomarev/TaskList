package easysales.tasklist.view.dialog;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import easysales.tasklist.ApplicationWrapper;
import easysales.tasklist.R;
import easysales.tasklist.model.Task;
import easysales.tasklist.presenter.TaskEditPresenter;
import easysales.tasklist.view.TaskEditView;
import easysales.tasklist.view.base.BaseDialogFragment;
import easysales.tasklist.util.DataHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaskEditDialog extends BaseDialogFragment implements TaskEditView {
    public static final String TAG = "TaskEditDialog";
    public static final String ARG_TASK = "task";

    @Inject
    TaskEditPresenter presenter;

    @BindView(R.id.task_title_edit)
    EditText taskDescriptionEdit;

    @BindView(R.id.spend_time)
    EditText spendTimeEdit;

    private Task task;

    public TaskEditDialog() {
        // Required empty public constructor
    }

    @NonNull
    public static TaskEditDialog newInstance(Task task) {
        TaskEditDialog taskEditDialog = new TaskEditDialog();
        Bundle args = new Bundle();
        args.putSerializable(ARG_TASK, task);
        taskEditDialog.setArguments(args);
        return taskEditDialog;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_task_edit, null);
        builder.setView(view);
        ButterKnife.bind(this, view);

        if(getArguments() != null) {
            task = (Task) getArguments().getSerializable(ARG_TASK);
        }

        ApplicationWrapper.getAppComponent().injectTaskEditFragment(this);

        if(task.number == null || TextUtils.isEmpty(task.number)) {
            builder.setTitle(String.format(Locale.getDefault(), getString(R.string.new_task)));
        }else {
            builder.setTitle(String.format(Locale.getDefault(), "%s№ %s", getString(R.string.task), task.number));
        }

        builder.setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(confirmRunnable != null) {
                    confirmRunnable.run();
                }
            }
        });

        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(cancelRunnable != null ) {
                    cancelRunnable.run();
                }
            }
        });

        return builder.create();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onTaskSaveClick() {
        presenter.saveTask(task);
    }

    @Override
    public void onTaskDeleteClick() {
        presenter.deleteTask(task);
        this.dismiss();
    }

    @Override
    public void showTask(Task task) {
        this.taskDescriptionEdit.setText(task.description);
        this.spendTimeEdit.setText(String.format(Locale.getDefault(), "%d", task.spandMinuts/60));
    }

    @Override
    public TaskData getTaskData() {
        TaskData taskData = new TaskData();
        taskData.setDescription(taskDescriptionEdit.getText().toString());
        taskData.setSpendTime(DataHelper.parseInteger(spendTimeEdit.getText().toString(), 0));
        return taskData;
    }
}
