package easysales.tasklist.view;

import easysales.tasklist.model.Task;
import easysales.tasklist.view.base.MvpView;

/**
 * Created by lordp on 02.11.2017.
 */

public interface TaskEditView extends MvpView {
    void onTaskSaveClick();
    void onTaskDeleteClick();

    void showTask(Task task);

    Task getTask();
    TaskData getTaskData();

    public class TaskData {
        private String description;
        private int spendTime;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getSpendTime() {
            return spendTime;
        }

        public void setSpendTime(int spendTime) {
            this.spendTime = spendTime;
        }
    }
}
