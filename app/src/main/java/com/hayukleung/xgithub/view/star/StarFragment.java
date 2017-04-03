package com.hayukleung.xgithub.view.star;

import android.view.View;
import com.hayukleung.xgithub.R;
import com.hayukleung.xgithub.view.XFragment;

/**
 * XGitHub
 * com.hayukleung.xgithub.view.star
 * StarFragment.java
 *
 * by hayukleung
 * at 2017-04-03 20:52
 */

public class StarFragment extends XFragment {

  @Override protected int getContentView() {
    return R.layout.content_star;
  }

  @Override protected View.OnClickListener getRetryListener() {
    return null;
  }
}
