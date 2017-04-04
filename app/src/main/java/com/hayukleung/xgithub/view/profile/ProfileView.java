package com.hayukleung.xgithub.view.profile;

import com.hayukleung.mvp.MVPView;
import com.hayukleung.xgithub.model.GitHub;

/**
 * XGitHub
 * com.hayukleung.xgithub.view
 * MainView.java
 *
 * by hayukleung
 * at 2017-04-02 17:12
 */

public interface ProfileView extends MVPView {

  void showContent(GitHub gitHub);
}
