package com.hayukleung.xgithub;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import javax.inject.Inject;

/**
 * XGitHub
 * com.hayukleung.xgithub
 * TestActivity.java
 *
 * by hayukleung
 * at 2017-03-30 23:02
 */

public class TestActivity extends AppCompatActivity {

  @Inject GitHubApiService mGitHubApiService;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }
}
