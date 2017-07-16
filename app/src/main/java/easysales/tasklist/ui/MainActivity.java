package easysales.tasklist.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;

import easysales.tasklist.R;
import easysales.tasklist.model.Task;
import easysales.tasklist.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showTaskListFragment();
    }

    public void showTaskListFragment() {
        replaceFragment(TaskListFragment.newInstance(), false);
    }
}
