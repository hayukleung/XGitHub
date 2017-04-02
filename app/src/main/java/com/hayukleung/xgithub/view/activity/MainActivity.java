package com.hayukleung.xgithub.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * XGitHub
 * com.hayukleung.xgithub.view.activity
 * MainActivity.java
 *
 * by hayukleung
 * at 2017-03-31 18:00
 */

public class MainActivity extends BaseActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mGitHubApiModule.providesGitHubApi(
        mGitHubApiModule.providesRetrofit(mGitHubApiModule.providesOkHttpClient()))
        .api("hayukleung")
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<Object>() {
          @Override public void onSubscribe(Disposable d) {

          }

          @Override public void onNext(Object value) {

          }

          @Override public void onError(Throwable e) {

          }

          @Override public void onComplete() {

          }
        });
  }
}
