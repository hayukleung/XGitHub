package com.hayukleung.xgithub;

import android.content.Context;
import android.support.multidex.MultiDexApplication;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * XGitHub
 * com.hayukleung.xgithub
 * App.java
 *
 * by hayukleung
 * at 2017-03-31 09:25
 */

public class App extends MultiDexApplication {

  private static final String TAG = "XGitHub";
  private AppComponent mAppComponent;

  public static App getInstance(Context context) {
    return (App) context.getApplicationContext();
  }

  public AppComponent getAppComponent() {
    if (null == mAppComponent) {
      mAppComponent = DaggerAppComponent.builder()
          .gitHubApiModule(new GitHubApiModule())
          .appModule(new AppModule(this))
          .build();
    }
    return mAppComponent;
  }

  @Override public void onCreate() {
    super.onCreate();
    initLogger();
  }

  private void initLogger() {
    Logger
        // default PRETTYLOGGER or use just init()
        .init(TAG)
        // default 2
        .methodCount(3)
        // default shown
        .hideThreadInfo()
        // default LogLevel.FULL
        .logLevel(BuildConfig.DEBUG ? LogLevel.FULL : LogLevel.NONE)
        // default 0
        .methodOffset(2);
    // default AndroidLogAdapter
    // .logAdapter();
  }
}
