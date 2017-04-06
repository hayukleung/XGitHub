package com.hayukleung.xgithub.view;

import com.hayukleung.xgithub.di.module.GitHubApiModule;
import com.trello.rxlifecycle2.components.support.RxFragment;

public class BaseFragment extends RxFragment {

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
