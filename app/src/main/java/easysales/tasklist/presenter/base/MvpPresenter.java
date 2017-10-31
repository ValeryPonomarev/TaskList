package easysales.tasklist.presenter.base;

import easysales.tasklist.view.base.MvpView;

/**
 * Created by lordp on 31.10.2017.
 */

public interface MvpPresenter<V extends MvpView> {
    void attachView(V mvpView);
    void onViewLoaded();
    void detachView();
    void destroy();
}
