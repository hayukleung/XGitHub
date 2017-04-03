package com.hayukleung.xgithub.view.trending;

import android.view.View;
import com.hayukleung.xgithub.R;
import com.hayukleung.xgithub.view.XFragment;

/**
 * XGitHub
 * com.hayukleung.xgithub.view
 * TrendingFragment.java
 *
 * by hayukleung
 * at 2017-04-03 20:51
 */

public class TrendingFragment extends XFragment {

  @Override protected int getContentView() {
    return R.layout.content_trending;
  }

  @Override protected View.OnClickListener getRetryListener() {
    return null;
  }
}
