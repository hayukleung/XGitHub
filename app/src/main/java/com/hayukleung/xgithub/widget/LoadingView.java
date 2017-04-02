package com.hayukleung.xgithub.widget;

import android.app.AlertDialog;
import android.content.Context;

public class LoadingView {

  private AlertDialog mLoadingDialog;

  public LoadingView(Context context, String message) {
    // TODO
  }

  public void show() {
    mLoadingDialog.show();
  }

  public void dismiss() {
    mLoadingDialog.dismiss();
  }
}
