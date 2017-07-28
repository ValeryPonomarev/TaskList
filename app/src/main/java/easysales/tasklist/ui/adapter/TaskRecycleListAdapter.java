package easysales.tasklist.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import easysales.tasklist.R;
import easysales.tasklist.model.Task;

/**
 * Created by lordp on 16.07.2017.
 */

public class TaskRecycleListAdapter extends RecyclerView.Adapter<TaskRecycleListAdapter.TaskViewHolder> {

    private List<Task> tasks;
    private TaskViewHolder.OnItemClickListener itemClickListener;

    public TaskRecycleListAdapter(List<Task> tasks, TaskViewHolder.OnItemClickListener listener) {
        this.tasks = tasks;
        itemClickListener = listener;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_task_list_item, parent, false);
        TaskViewHolder holder = new TaskViewHolder(view, itemClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        holder.bind(tasks.get(position));
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Task task;
        private OnItemClickListener itemClickListener;

        @BindView(R.id.task_number_view)
        TextView taskNumberView;

        @BindView(R.id.task_description_view)
        TextView taskTitleView;

        public TaskViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemClickListener = listener;
            itemView.setOnClickListener(this);
        }

        public void bind(Task task) {
            this.task = task;
            taskNumberView.setText(task.number);
            taskTitleView.setText(task.description);
        }

        @Override
        public void onClick(View view) {
            if(itemClickListener != null) {
                itemClickListener.onItemClick(task);
            }
        }

        public interface OnItemClickListener {
            void onItemClick(Task task);
        }
    }
}
