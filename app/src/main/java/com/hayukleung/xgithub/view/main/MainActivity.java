package com.hayukleung.xgithub.view.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.hayukleung.xgithub.di.HasComponent;
import com.hayukleung.xgithub.di.component.DaggerMainComponent;
import com.hayukleung.xgithub.di.component.MainComponent;
import com.hayukleung.xgithub.di.module.ActivityModule;
import com.hayukleung.xgithub.presenter.MainPresenter;
import com.hayukleung.xgithub.view.XActivity;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;

/**
 * XGitHub
 * com.hayukleung.xgithub.view.activity
 * MainActivity.java
 *
 * by hayukleung
 * at 2017-03-31 18:00
 */

public class MainActivity extends XActivity implements MainView, HasComponent<MainComponent> {

  @Inject protected MainPresenter mPresenter;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getComponent().inject(this);
    mPresenter.attachView(this);

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

  @Override public MainComponent getComponent() {
    return DaggerMainComponent.builder()
        .appComponent(getAppComponent())
        .activityModule(new ActivityModule(this))
        .build();
  }

  @Override protected void onDestroy() {
    mPresenter.detachView();
    super.onDestroy();
  }
}
