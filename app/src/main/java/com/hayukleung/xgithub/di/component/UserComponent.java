package com.hayukleung.xgithub.di.component;

import com.hayukleung.xgithub.di.PerActivity;
import com.hayukleung.xgithub.di.module.ActivityModule;
import com.hayukleung.xgithub.di.module.UserModule;
import com.hayukleung.xgithub.view.BaseFragment;
import dagger.Component;

/**
 * XGitHub
 * com.hayukleung.xgithub.di.component
 * UserComponent.java
 *
 * by hayukleung
 * at 2017-03-31 16:31
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = { ActivityModule.class, UserModule.class })
public interface UserComponent extends ActivityComponent {

  void inject(BaseFragment baseFragment);
}
