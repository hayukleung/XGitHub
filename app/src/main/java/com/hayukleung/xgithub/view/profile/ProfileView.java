package com.hayukleung.xgithub.view.profile;

import com.hayukleung.mvp.lce.LoadView;
import com.hayukleung.xgithub.model.GitHub;

/**
 * XGitHub
 * com.hayukleung.xgithub.view
 * MainView.java
 *
 * by hayukleung
 * at 2017-04-02 17:12
 */

public interface ProfileView extends LoadView {

  void showContent(GitHub gitHub);
}
