package easysales.tasklist.view.base;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import easysales.tasklist.R;

/**
 * Created by lordp on 16.07.2017.
 */

public class BaseActivity extends AppCompatActivity {

    public void replaceFragment(MvpFragment fragment, boolean putToBackStack) {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment, fragment.getUserTag())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

        if(putToBackStack) {
            transaction = transaction.addToBackStack(fragment.getUserTag());
        }

        transaction.commit();
    }
}
