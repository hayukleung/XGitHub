package com.hayukleung.xgithub;

import dagger.Component;

/**
 * XGitHub
 * com.hayukleung.xgithub
 * AppComponent.java
 *
 * by hayukleung
 * at 2017-03-31 10:23
 */

@Component(modules = { AppModule.class, GitHubApiModule.class }) public interface AppComponent {

  void inject(TestActivity testActivity);
}
