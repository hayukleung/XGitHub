package com.hayukleung.xgithub.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.hayukleung.xgithub.di.HasComponent;

/**
 * XGitHub
 * com.hayukleung.xgithub.view.Activity
 * BaseFragment.java
 *
 * by hayukleung
 * at 2017-03-31 16:33
 */

public class BaseFragment extends Fragment {

  protected <C> C getComponent(Class<C> componentType) {
    FragmentActivity activity = getActivity();
    if (activity instanceof HasComponent) {
      HasComponent hasComponent = (HasComponent) activity;
      return componentType.cast(hasComponent.getComponent());
    }
    return null;
  }
}
