package com.hayukleung.mvp.lce;

import android.support.annotation.UiThread;
import com.hayukleung.mvp.MVPView;

/**
 * XGitHub
 * com.hayukleung.mvp.lce
 * LCEView.java
 *
 * by hayukleung
 * at 2017-04-02 14:59
 */

public interface LCEView<M> extends MVPView {

  @UiThread public void showLoading();

  @UiThread public void dismissLoading();

  @UiThread public void showContent(M data);

  @UiThread public void showError(Throwable e);

  @UiThread public void showEmpty();
}
