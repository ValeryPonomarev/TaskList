package easysales.tasklist.presenter.base;

import android.support.annotation.NonNull;
import android.view.View;

import easysales.tasklist.view.base.MvpView;

/**
 * Created by lordp on 31.10.2017.
 */

public interface MvpPresenter<V extends MvpView> {
    void attachView(V view);
    void onViewLoaded();
    void detachView();
    void destroy();
}
