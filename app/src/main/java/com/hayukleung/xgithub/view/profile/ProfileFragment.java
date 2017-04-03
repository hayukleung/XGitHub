package com.hayukleung.xgithub.view.profile;

import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hayukleung.xgithub.R;
import com.hayukleung.xgithub.view.XFragment;

/**
 * XGitHub
 * com.hayukleung.xgithub.view.profile
 * ProfileFragment.java
 *
 * by hayukleung
 * at 2017-04-03 20:53
 */

public class ProfileFragment extends XFragment {

  @BindView(R.id.text) TextView mTextView;

  @Override protected int getContentView() {
    return R.layout.content_profile;
  }

  @Override protected View.OnClickListener getRetryListener() {
    return null;
  }

  @OnClick({ R.id.text }) void onClick(View view) {

  }
}
