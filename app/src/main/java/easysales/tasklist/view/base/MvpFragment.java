package easysales.tasklist.view.base;

import android.support.v4.app.Fragment;

/**
 * Created by lordp on 16.07.2017.
 */

public abstract class MvpFragment extends Fragment implements MvpView {
    public String getUserTag() {
        return MvpFragment.class.getSimpleName();
    }
}
