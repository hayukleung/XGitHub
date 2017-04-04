package com.hayukleung.xgithub.view;

import android.support.v4.app.Fragment;
import com.hayukleung.xgithub.di.module.GitHubApiModule;

public class BaseFragment extends Fragment {

  // protected <C> C getComponent(Class<C> componentType) {
  // FragmentActivity activity = getActivity();
  // if (activity instanceof HasComponent) {
  // HasComponent hasComponent = (HasComponent) activity;
  // return componentType.cast(hasComponent.getComponent());
  // }
  // return null;
  // }

  public boolean onBackPressed() {
    return false;
  }

  protected GitHubApiModule getGitHubApiModule() {
    return getBaseActivity().mGitHubApiModule;
  }

  protected BaseActivity getBaseActivity() {
    return (BaseActivity) getActivity();
  }
}
