package easysales.tasklist.presenter.base;

import android.support.annotation.NonNull;

import easysales.tasklist.view.base.MvpView;

/**
 * Created by lordp on 31.10.2017.
 */

public abstract class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private V view;

    public V getView() {
        return view;
    }

    @Override
    public void attachView(@NonNull V mvpView) {
        view = mvpView;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void destroy() {

    }
}
