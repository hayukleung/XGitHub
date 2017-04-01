package com.hayukleung.xgithub.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

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
        mGitHubApiModule.providesRetrofit(mGitHubApiModule.providesOkHttpClient())).api("");
  }
}
