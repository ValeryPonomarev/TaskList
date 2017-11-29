package easysales.tasklist.view.base;

import android.support.v4.app.Fragment;

import easysales.tasklist.presenter.base.MvpPresenter;

/**
 * Created by lordp on 16.07.2017.
 */

public abstract class MvpFragment extends Fragment implements MvpView {
    public String getUserTag() {
        return getClass().getSimpleName();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getPresenter().detachView();
    }

    protected abstract MvpPresenter getPresenter();
}
