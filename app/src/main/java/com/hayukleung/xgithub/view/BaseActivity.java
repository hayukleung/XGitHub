package com.hayukleung.xgithub.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.hayukleung.xgithub.App;
import com.hayukleung.xgithub.di.component.AppComponent;
import com.hayukleung.xgithub.di.module.ActivityModule;
import com.hayukleung.xgithub.di.module.GitHubApiModule;
import javax.inject.Inject;

/**
 * XGitHub
 * com.hayukleung.xgithub.view.Activity
 * BaseActivity.java
 *
 * by hayukleung
 * at 2017-03-31 16:17
 */

public class BaseActivity extends AppCompatActivity {


  // @Inject 告诉 Dagger 说 mGitHubApi 需要依赖注入
  // 于是 Dagger 就会构造一个 GitHubApi 的实例并满足它
  @Inject GitHubApiModule mGitHubApiModule;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getAppComponent().inject(this);
  }

  /**
   * Get the Main Application component for dependency injection.
   *
   * @return
   */
  public AppComponent getAppComponent() {
    return ((App) getApplicationContext()).getAppComponent();
  }

  /**
   * Get an Activity module for dependency injection.
   *
   * @return
   */
  protected ActivityModule getActivityModule() {
    return new ActivityModule(this);
  }
}
