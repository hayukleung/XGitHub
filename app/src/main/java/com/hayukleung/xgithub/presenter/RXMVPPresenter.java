package com.hayukleung.xgithub.presenter;

import com.hayukleung.mvp.BaseMVPPresenter;
import com.hayukleung.mvp.MVPView;
import io.reactivex.disposables.CompositeDisposable;

/**
 * XGitHub
 * com.hayukleung.xgithub.presenter
 * RXMVPPresenter.java
 *
 * by hayukleung
 * at 2017-04-02 15:06
 */

public class RXMVPPresenter<V extends MVPView> extends BaseMVPPresenter<V> {

  protected CompositeDisposable mCompositeDisposable;

  @Override public void attachView(V view) {
    super.attachView(view);
    mCompositeDisposable = new CompositeDisposable();
  }

  @Override public void detachView() {
    super.detachView();
    mCompositeDisposable.clear();
    mCompositeDisposable = null;
  }
}
