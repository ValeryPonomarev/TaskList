package easysales.tasklist.ui.dialog;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import easysales.tasklist.R;
import easysales.tasklist.model.Task;
import easysales.tasklist.ui.base.BaseDialogFragment;
import easysales.tasklist.util.DataHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaskEditDialog extends BaseDialogFragment {
    public static final String TAG = "TaskEditFragment";
    public static final String ARG_TASK = "task";

    private Task task;

    @BindView(R.id.task_title_edit)
    EditText taskDescriptionEdit;

    @BindView(R.id.spend_time)
    EditText spendTimeEdit;

    public TaskEditDialog() {
        // Required empty public constructor
    }

    public static TaskEditDialog newInstance(Task task) {
        TaskEditDialog taskEditDialog = new TaskEditDialog();
        Bundle args = new Bundle();
        args.putSerializable(ARG_TASK, task);
        taskEditDialog.setArguments(args);
        return taskEditDialog;
    }

    public String getDescription() {
        return taskDescriptionEdit.getText().toString();
    }

    public Integer getSpendTime() {
        return DataHelper.parseInteger(spendTimeEdit.getText().toString(), 0);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_task_edit, null);
        builder.setView(view);
        ButterKnife.bind(this, view);

        if(getArguments() != null) {
            task = (Task) getArguments().getSerializable(ARG_TASK);
        }

        if(task.number == null || TextUtils.isEmpty(task.number)) {
            builder.setTitle(String.format(Locale.getDefault(), getString(R.string.new_task)));
        }else {
            builder.setTitle(String.format(Locale.getDefault(), "%s№ %s", getString(R.string.task), task.number));
        }

        fillForm();

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


        AlertDialog alertDialog = builder.create();

        return alertDialog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void fillForm(){
        if(task == null) {
            Log.d(TAG, "task is null");
            return;
        }

        this.taskDescriptionEdit.setText(task.description);
        this.spendTimeEdit.setText(String.format(Locale.getDefault(), "%d", task.spandMinuts/60));
    }
}
