package com.hayukleung.xgithub;

import dagger.Module;
import dagger.Provides;

/**
 * XGitHub
 * com.hayukleung.xgithub
 * AppModule.java
 *
 * by hayukleung
 * at 2017-03-31 10:24
 */

@Module public class AppModule {

  private App mApp;

  public AppModule(App app) {
    mApp = app;
  }

  @Provides public App providesApp() {
    return mApp;
  }
}
