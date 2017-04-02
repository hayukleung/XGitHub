package com.hayukleung.xgithub.di.component;

import com.hayukleung.xgithub.di.PerActivity;
import com.hayukleung.xgithub.di.module.ActivityModule;
import com.hayukleung.xgithub.view.MainActivity;
import dagger.Component;

/**
 * XGitHub
 * com.hayukleung.xgithub.di.component
 * MainComponent.java
 *
 * by hayukleung
 * at 2017-04-02 17:38
 */
@PerActivity @Component(dependencies = AppComponent.class, modules = {
    ActivityModule.class
}) public interface MainComponent extends ActivityComponent {
  void inject(MainActivity mainActivity);
}
