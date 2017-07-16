package easysales.tasklist.ui.base;

import android.content.Context;

import easysales.tasklist.ui.MainActivity;

/**
 * Created by lordp on 16.07.2017.
 */

public class BaseMainFragment extends BaseFragment {

    public static final String TAG = "BaseMainFragment";

    public MainActivity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (MainActivity) context;
    }

    @Override
    public String getUserTag() {
        return TAG;
    }
}
