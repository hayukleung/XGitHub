package com.hayukleung.xgithub.presenter;

import com.hayukleung.xgithub.di.module.GitHubApiModule;
import com.hayukleung.xgithub.model.GitHub;
import com.hayukleung.xgithub.view.profile.ProfileView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;

/**
 * XGitHub
 * com.hayukleung.xgithub.presenter.main
 * MainPresenter.java
 *
 * by hayukleung
 * at 2017-04-02 17:03
 */

public class ProfilePresenter extends RXMVPPresenter<ProfileView> {

  @Inject public ProfilePresenter() {
  }

  public void request(GitHubApiModule gitHubApiModule) {

    // TODO
    gitHubApiModule.providesGitHubApi(
        gitHubApiModule.providesRetrofit(gitHubApiModule.providesOkHttpClient()))
        .api("hayukleung")
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<GitHub>() {
          @Override public void onSubscribe(Disposable d) {

          }

          @Override public void onNext(GitHub value) {
            checkViewAttached();
            getMVPView().showContent(value);
          }

          @Override public void onError(Throwable e) {

          }

          @Override public void onComplete() {

          }
        });
  }
}
