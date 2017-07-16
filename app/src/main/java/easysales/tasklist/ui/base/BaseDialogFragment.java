package easysales.tasklist.ui.base;

import android.support.v4.app.DialogFragment;

/**
 * Created by lordp on 16.07.2017.
 */

public class BaseDialogFragment extends DialogFragment {
    protected Runnable confirmRunnable;
    protected Runnable cancelRunnable;

    public void setConfirmRunnable(Runnable runnable) {
        confirmRunnable = runnable;
    }

    public void setCancelRunnalbe(Runnable runnable) {
        cancelRunnable = runnable;
    }
}
