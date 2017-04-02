package com.hayukleung.xgithub.view;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import com.hayukleung.mvp.lce.LoadView;
import com.hayukleung.xgithub.widget.LoadingView;

public abstract class BaseLoadingActivity extends BaseActivity implements LoadView {

  private LoadingView mLoadingView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mLoadingView = new LoadingView(this, getLoadingMessage());
  }

  public abstract String getLoadingMessage();

  @Override public void showLoading() {
    mLoadingView.show();
  }

  @Override public void dismissLoading() {
    mLoadingView.dismiss();
  }

  @Override public void error(Throwable e) {
    Snackbar.make(getWindow().getDecorView(), e.getMessage(), Snackbar.LENGTH_LONG).show();
  }
}
