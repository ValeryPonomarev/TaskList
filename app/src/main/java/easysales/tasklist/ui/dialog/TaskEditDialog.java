package easysales.tasklist.ui.dialog;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import easysales.tasklist.R;
import easysales.tasklist.model.Task;
import easysales.tasklist.ui.base.BaseDialogFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaskEditDialog extends BaseDialogFragment {
    public static final String TAG = "TaskEditFragment";
    public static final String ARG_TASK = "task";

    private Task task;

    @BindView(R.id.task_number_view)
    TextView taskNumberView;

//    @BindView(R.id.task_title_edit)
//    EditText taskTitleEdit;

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

    public String getNumber() {
        return taskNumberView.getText().toString();
    }

    public String getTitle() {
//        return taskTitleEdit.getText().toString();
        return "";
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle("title");

        View view = View.inflate(getContext(), R.layout.dialog_task_edit, null);
        ButterKnife.bind(this, view);

        fillForm();

        builder.setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(confirmRunnable != null) {
                    confirmRunnable.run();
                }
            }
        });

        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
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
        if(getArguments() != null) {
            task = (Task) getArguments().getSerializable(ARG_TASK);
        }

    }

    private void fillForm(){
        if(task == null) {
            Log.d(TAG, "task is null");
        }

        this.taskNumberView.setText(task.number);
//        this.taskTitleEdit.setText(task.title);
    }
}
