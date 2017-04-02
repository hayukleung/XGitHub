package com.hayukleung.mvp.lce;

import android.support.annotation.UiThread;
import com.hayukleung.mvp.MVPView;

/**
 * XGitHub
 * com.hayukleung.mvp.lce
 * LoadView.java
 *
 * by hayukleung
 * at 2017-04-02 15:00
 */

public interface LoadView extends MVPView {

  @UiThread public void showLoading();

  @UiThread public void dismissLoading();

  @UiThread public void error(Throwable e);
}
