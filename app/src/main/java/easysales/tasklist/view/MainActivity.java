package easysales.tasklist.view;

import android.os.Bundle;

import easysales.tasklist.R;
import easysales.tasklist.view.base.BaseActivity;

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
