package easysales.tasklist.view.base;

import android.support.v4.app.DialogFragment;

/**
 * Created by lordp on 16.07.2017.
 */

public class MvpDialogFragment extends DialogFragment implements MvpView {
    protected Runnable confirmRunnable;
    protected Runnable cancelRunnable;

    public void setConfirmRunnable(Runnable runnable) {
        confirmRunnable = runnable;
    }

    public void setCancelRunnalbe(Runnable runnable) {
        cancelRunnable = runnable;
    }

    protected String getUserTag() {
        return getClass().getSimpleName();
    }
}
