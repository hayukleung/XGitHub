package com.hayukleung.xgithub.di.module;

import com.hayukleung.xgithub.di.PerActivity;
import com.hayukleung.xgithub.view.BaseActivity;
import dagger.Module;
import dagger.Provides;

/**
 * XGitHub
 * com.hayukleung.xgithub.di.module
 * ActivityModule.java
 *
 * by hayukleung
 * at 2017-03-31 16:11
 */

@Module public class ActivityModule {

  private final BaseActivity mBaseActivity;

  public ActivityModule(BaseActivity baseActivity) {
    mBaseActivity = baseActivity;
  }

  @Provides @PerActivity BaseActivity providesActivity() {
    return mBaseActivity;
  }
}
