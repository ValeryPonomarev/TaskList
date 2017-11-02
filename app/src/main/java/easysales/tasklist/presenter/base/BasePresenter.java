package easysales.tasklist.presenter.base;

import android.support.annotation.NonNull;
import android.view.View;

import easysales.tasklist.view.base.MvpView;

/**
 * Created by lordp on 31.10.2017.
 */

public abstract class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private V view;

    protected String getUserTag() {
        return this.getClass().getSimpleName();
    };

    public V getView() {
        return view;
    }

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void destroy() {

    }
}
